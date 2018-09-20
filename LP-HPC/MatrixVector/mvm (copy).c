#include <stdio.h>
#include <stdlib.h>
#include <omp.h>   
   
    void mxv(int m, int n, double * restrict a,
        double * restrict b, double * restrict c)
{
    int i, j;
#pragma omp parallel for default(none) \
    shared(m,n,a,b,c) private(i,j)
    for (i=0; i<m; i++)
        {
            a[i] = 0.0;
            for (j=0; j<n; j++)
            a[i] += b[i][j]*c[j];
        } /*-- End of omp parallel for --*/
}

  void mxv_serial(int m, int n, double * restrict a,double * restrict b, double * restrict c)
{
    int i, j;
 for (i=0; i<m; i++)
        {
            a[i] = 0.0;
            for (j=0; j<n; j++)
            a[i] += b[i][j]*c[j];
            //a[i] += b[i*n+j]*c[j];
        }
}

    int main()
 {
    double a[20][20];
    double b[20][20];
    double c[20][20];
    double m=5,n=5;
    for(int i=0; i<m; i++)
        for(int j=0; j<n; j++){
            c[i][j]=2;
            b[i][j]=3;
        }
        
   double start = omp_get_wtime();  
    mxv_serial(m,n,a,b,c);  
   double end = omp_get_wtime(); 
   double elapsed=end-start;        
    //printf("MVM  Serial:%f\n",elapsed);
    for(int i=0;i<20;i++){
     printf("%f",a[i]);
    }    
    
    start = omp_get_wtime();  
    mxv(m,n,a,b,c);  
   end = omp_get_wtime(); 
   elapsed=end-start;        
    printf("MVM Parallel:%f\n",elapsed);  
  
    
 }

#include <stdio.h>
#include <stdlib.h>
#include <omp.h>   
#define SIZE 1200   
    void mxv(int m, int n, int *  a,
        int b[SIZE][SIZE], int *  c)
{
    int i, j;
#pragma omp parallel for default(none) \
    shared(m,n,a,b,c) private(i,j)
    for (i=0; i<m; i++)
        {
            a[i] = 0;
            for (j=0; j<n; j++)
            a[i] += b[i][j]*c[j];
        } /*-- End of omp parallel for --*/
}


  void mxv_serial(int m, int n, int *a,int b[SIZE][SIZE], int*c)
{
    int i, j;
 for (i=0; i<m; i++)
        {
            a[i] = 0;
            for (j=0; j<n; j++)
            a[i] += b[i][j]*c[j];
            //a[i] += b[i*n+j]*c[j];
        }
}

    int main()
 {
    int a[SIZE];
    int b[SIZE][SIZE];
    int c[SIZE];
    int m=SIZE,n=SIZE;
    for(int i=0; i<m; i++){
        for(int j=0; j<n; j++){
            b[i][j]=3;
        }
    }
    for(int i=0;i<m;i++){
     c[i]=2;    
    } 
        
   double start = omp_get_wtime();  
    mxv_serial(m,n,a,b,c);  
   double end = omp_get_wtime(); 
   double elapsed=end-start;        
    printf("MVM  Serial:%f\n",elapsed);
    for(int i=0;i<SIZE;i++){
     //printf("%d\n",a[i]);
    }    
    
      for(int i=0;i<m;i++){
     c[i]=2;    
    } 
  
    start = omp_get_wtime();  
    mxv(m,n,a,b,c);  
   end = omp_get_wtime(); 
   elapsed=end-start;        
    printf("MVM Parallel:%f\n",elapsed);  
      for(int i=0;i<SIZE;i++){
    // printf("%d\n",a[i]);
    }    
  
    
 }

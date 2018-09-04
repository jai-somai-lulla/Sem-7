#include <stdio.h>
#include <stdlib.h>
   
   
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
            a[i] += b[i*n+j]*c[j];
        } /*-- End of omp parallel for --*/
}





    int main()
 {
    double a[20][20];
    double b[20][20];
    double c[20][20]
    double m=5,n=5;
    for(int i=0; i<m; i++)
        for(int j=0; j<n; j++){
            a[i][j]=2;
            b[i][j]=3;
        }
    mxv(m,n,c,a,b);  
    printf("MVM \n");
    
 }

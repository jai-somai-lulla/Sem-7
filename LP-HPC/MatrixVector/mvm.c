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

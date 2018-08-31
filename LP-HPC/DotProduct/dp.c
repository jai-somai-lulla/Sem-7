int main(argc,argv)
int argc; char *argv[];
{
double sum;
double a [256], b [256];
int status;
int n=8;
int i;
//#pragma omp parallel
//printf("Hello\n");

for (i = 0; i < n; i++) {
a [i] = i * 0.5;
b [i] = i * 2.0;
}
sum = 0;
int tid=0;

#pragma omp parallel for reduction(+: sum)
for (i = 0; i < n; i++ ) {
tid = omp_get_thread_num();
sum = sum + a[i]*b[i];
printf ("TID:%d  Iteration:%d sum:%f \n",tid,i,sum);
}

printf ("Final sum = %f \n", sum);
//printf ("Average  = %f \n", sum/n);

}

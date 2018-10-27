#include<stdio.h>
#include<unistd.h>
#include<stdlib.h>
#include<omp.h>
#define SIZE 700
void setup(int arr[SIZE][SIZE]){
    //srand(time(NULL));
    for(int i=0;i<SIZE;i++){
        for(int j=0;j<SIZE;j++){
            arr[i][j]=rand()%5+1;
        }
    }
}

void show(int arr[SIZE][SIZE]){
    for(int i=0;i<SIZE;i++){
        for(int j=0;j<SIZE;j++){
            printf("%d ",arr[i][j]);
        }
        printf("\n");
    }
}

void matmul(int a[SIZE][SIZE],int b[SIZE][SIZE],int c[SIZE][SIZE]){
    for(int i=0;i<SIZE;i++){
        for(int j=0;j<SIZE;j++){
            c[i][j]=0;
            for(int k=0;k<SIZE;k++){
                c[i][j]+=a[i][k]*b[k][j];
            }
        }
    }
}

void matmulParallel(int a[SIZE][SIZE],int b[SIZE][SIZE],int c[SIZE][SIZE]){
    #pragma omp parallel
    {
    #pragma omp for
    for(int i=0;i<SIZE;i++){
        for(int j=0;j<SIZE;j++){
            c[i][j]=0;
            //#pragma omp for
            for(int k=0;k<SIZE;k++){
                c[i][j]+=a[i][k]*b[k][j];
            }
        }
      }
    }
}
int equal(int a[SIZE][SIZE],int b[SIZE][SIZE]){
int eq=1;
    for(int i=0;i<SIZE;i++){
        for(int j=0;j<SIZE;j++){
            eq=eq&&(a[i][j]==b[i][j]);
        }
    }
    return eq;
}
void setup1(int arr[SIZE]){
 for(int j=0;j<SIZE;j++){
            arr[i][j]=rand()%5+1;
        }
}

void vectormat(int arr[SIZE][SIZE],int vect[SIZE],int ans[SIZE]){


}
int main(){
    int numprocs=0;
    int a[SIZE][SIZE];
    int b[SIZE][SIZE];
    int serial[SIZE][SIZE];
    int parallel[SIZE][SIZE];
    vect[SIZE];
    double start,end,elapsed;
    setup(a);
    setup1(vect);
    //setup(b);
   // show(a);
    printf("\n");
   // show(b);
    printf("\n");
    start=omp_get_wtime();
    matmul(a,b,serial);    
    end=omp_get_wtime();
    elapsed=end-start;
    printf("Serial Time :%f\n",elapsed);
    
    for(int num=1;num<=8;num++){
    //omp_set_dynamic(0);
    omp_set_num_threads(num);    
    start=omp_get_wtime();
    matmulParallel(a,b,parallel);    
    end=omp_get_wtime();
    elapsed=end-start;
    printf("Parallel Time [[%d]] :%f\n",num,elapsed);
    
   // printf("Equal : %d \n",equal(serial,parallel));
    //show(c);
   } 
    return 0;
}


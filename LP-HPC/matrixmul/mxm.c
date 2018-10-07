#include <stdio.h>
#include <omp.h>
#define row 1000

int a1[row][row],a2[row][row],as[row][row],ap[row][row],m,n;
//int C[row*row];
void setup(int a1[row][row],int a2[row][row]){
   for(int i=0;i<row;i++){
        for(int j=0;j<row;j++){
            a1[i][j]=10+(i-j);
            a2[i][j]=3+(i+j);
           // printf("%d%d ",i,j);
        }
   } 
}   

void tear_down(double start,double end){
    double elapsed=end-start;
    printf("Time Elapsed:%f:\n",elapsed);
    int allgood=0;
    for(int i=0;i<row;i++){
        for(int j=0;j<row;j++){
            //printf("%d ",ans[i][j]);
            if(as[i][j]!=ap[i][j]) {allgood=-1;break;}
        }
       
    }
     printf("AllGOOD:%d\n",allgood);
}

void serial_mult(){
    for(int i=0;i<row;i++){
        for(int j=0;j<row;j++){
            as[i][j]=0;
            for(int k=0;k<row;k++){
                as[i][j]+=a1[i][j]*a2[i][j];
            }
        }
    }
}

void parallel_mult(){

#pragma omp parallel
{ 
    #pragma omp for
    for(int i=0;i<row;i++){
        for(int j=0;j<row;j++){
            ap[i][j]=0;
            
            for(int k=0;k<row;k++){
                ap[i][j]+=a1[i][j]*a2[i][j];
            }            
            
        }
    }
}    
}

int main(){
int num_process=0;
double start,end,elapsed;
#pragma omp parallel 
{   
    #pragma omp master
    {
    num_process=omp_get_num_procs(); 
    }       
}
setup(a1,a2);
printf("Serial\n");
start= omp_get_wtime();
serial_mult();
end=omp_get_wtime();
tear_down(start,end);

printf("\n\nParallel\n");
start= omp_get_wtime();
parallel_mult();
end=omp_get_wtime();
tear_down(start,end);

return 0;
}



#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>
#include <omp.h>
#define SIZE 100000
void setUp(int a[], int size);
void tearDown(double start, double end, int a[], int size);


void setUp(int a[], int size){
	int i;
	srand(time(NULL));
	for (i = 0; i<size; ++i) {
		a[i] = rand() % size;
	}
	return;
}

void tearDown(double start, double end, int a[], int size) {
	int sorted = 1;
	int i;

	printf("Time to execute: %f\n", end-start);
	
	for (i = 0; i < size-1; ++i) {
		sorted &= (a[i] <= a[i+1]);
	}
	
	printf("Array sorted: %d\n", sorted);
	#pragma omp parallel
	{
		#pragma omp master
		{
			printf("Num threads: %d\n", omp_get_num_threads());
		}
	}
}


void oddeven(int x[],int n){
    int changes=1;
    int phase=0;
    int i,temp;
    int count=0;
    while(changes){
    changes=0;
    printf("Phase %d\n",count++);
    #pragma omp for private(temp)
     for(i = 0+phase; i < n - 1; i = i + 2)
            {
                    if(x[i] > x[i+1] )
                    {
                            temp = x[i];
                            x[i] = x[i+1];
                            x[i+1] = temp;
                            if(changes==0)
                            changes=1;
                    }
            }
            if(phase==0) phase=1;else phase=0;
      }
}


int main() {

    //omp_set_nested(1);
    //omp_set_dynamic(0);     // Explicitly disable dynamic teams
    //omp_set_num_threads(1); // Use 4 threads for all consecutive parallel regions

	int a[SIZE];
	//int temp[SIZE];
	double startTime, endTime;
	int num_threads;

	#pragma omp parallel
	{
		#pragma omp master
		{
			num_threads = omp_get_num_threads();
		}
	}
    printf("Thread Count:%d \n",num_threads);
	setUp(a, SIZE);
	startTime = omp_get_wtime();
	oddeven(a,SIZE);
	endTime = omp_get_wtime();

	tearDown(startTime, endTime, a, SIZE);
}


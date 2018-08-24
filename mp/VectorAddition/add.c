#include <stdio.h>
#include <omp.h>
#include<time.h>
#include<math.h> 

int main(void)
{
   int size=1;
    int i;
    long fact;
    double total_time_serial,total_time_parallel;
    clock_t start, end;
    float arr1[100000];
    float arr2[100000];
    float p[100000];
    float s[100000];
    start = clock();//time count starts 
    srand(time(NULL));
      #pragma omp parallel for
     for (i = 0; i < 100000; i++) 
    {
       arr1[i]=rand()*100;
       arr2[i]=rand()*100; 
     //  printf("fact[%d]= %f \n", i + 1, arr2[i]);
     
    }
    end = clock();//time count stops 
    total_time_parallel = ((double) (end - start)) /CLOCKS_PER_SEC;//calulate total time
    printf("Made The two arrays in %f\n",total_time_parallel);
    
    
    start = clock();//time count starts 
    srand(time(NULL));
      #pragma omp parallel for
     for (i = 0; i < 100000; i++) 
    {
       p[i]=arr1[i]+arr2[i];
    }
    end = clock();//time count stops 
    total_time_parallel = ((double) (end - start)) /CLOCKS_PER_SEC;//calulate total time
    printf("Added PARALLEL in %f \n",total_time_parallel);
    
    
    start = clock();//time count starts 
    srand(time(NULL));
     for (i = 0; i < 100000; i++) 
    {
       s[i]=arr1[i]+arr2[i];
    }
    end = clock();//time count stops 
    total_time_parallel = ((double) (end - start)) /CLOCKS_PER_SEC;//calulate total time
    printf("Added SERIAL in %f \n",total_time_parallel);

  return 0;
}

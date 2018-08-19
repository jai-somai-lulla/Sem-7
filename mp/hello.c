#include <stdio.h>
#include <omp.h>
#include<time.h>
#include<graphics.h> 
#include<math.h> 

//#include "koolplot.h"
//#define size 100000

int main(void)
{
   int size=1;
    //#pragma omp parallel
    //printf("Hello, world.\n");
    int i;
    long fact;
    double total_time_serial,total_time_parallel;
    clock_t start, end;
    float arr1[100000];
    float arr2[100000];
    float serial_stat[100000];
    float parallel_stat[100000];


for(size=1;size<100000;size++){
    start = clock();//time count starts 
    srand(time(NULL));
    for (i = 0; i < size; i++) 
    {
       arr1[i]=rand()*100;
       arr2[i]=rand()*100; 
      // printf("fact[%d]= %f \n", i + 1, arr2[i]);
     
    }
    end = clock();//time count stops 
    total_time_serial = ((double) (end - start)) /CLOCKS_PER_SEC;//calulate total time
    

    printf("\nSerial Complete %d",size); 
    start = clock();//time count starts 
    srand(time(NULL));
    

     #pragma omp parallel for
     for (i = 0; i < size; i++) 
    {
       arr1[i]=rand()*100;
       arr2[i]=rand()*100; 
     //  printf("fact[%d]= %f \n", i + 1, arr2[i]);
     
    }
    end = clock();//time count stops 
    total_time_parallel = ((double) (end - start)) /CLOCKS_PER_SEC;//calulate total time
    
    printf("\nParallel Complete %d",size); 
    serial_stat[size]=total_time_serial;  
    parallel_stat[size]=total_time_parallel;
    //printf("\n\nTime taken To make Array's Serially%d", (int)(total_time_parallel*100000));
    //printf("\nTime taken To make Array's Parallelly%f", total_time_serial);
    //printf("\nTime taken To make Array's Serially%f \n", total_time_parallel);
}
     printf("Making Graph\n");
    int gd = DETECT,gm,left=100,top=100,right=200,bottom=200,x= 300,y=300,radius=50;
    initgraph(&gd,&gm,NULL);   
    //rectangle(left, top, right, bottom);
    //putpixel(10,10, RED);		
    
// 640 480
  //  for(int i=480;i>300;i--){
    //  putpixel(600,i, RED);			
     //}

for(int i=0;i<((int)(size));i++){
//putpixel(i,50,GREEN);
putpixel((int)(((float)((float)i/(float)size))*640),(480-(int)(serial_stat[i]*10000)), RED);

//putpixel(i,100,GREEN);

putpixel((int)(((float)((float)i/(float)size))*640),(480-(int)(parallel_stat[i]*10000)), BLUE);
}

   delay(10000); 
   closegraph();
  return 0;
}

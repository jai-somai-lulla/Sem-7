#include<stdio.h>
#include<omp.h>
#include<unistd.h>
#include<stdlib.h>
#define SIZE 1000000

void setup(int arr[SIZE]){
    for(int i=0;i<(SIZE/2);i++){
        arr[i]=i*2;
        arr[(SIZE/2)+i]=i+1;
    }
    for(int i=0;i<SIZE/2;i++){
     arr[i]=i;
    }
    for(int i=SIZE/2;i<SIZE;i++){
     arr[i]=i;
    }
    for(int i=0;i<SIZE/2;i++){
     arr[i]=rand();
    }
}


void showarr(int arr[SIZE]){
    for(int i=0;i<SIZE;i++){
        printf("%d ",arr[i]);
    }
    printf("\n");
}


void merge(int arr[SIZE],int l,int m,int h){
    int left[m-l+1];
    int right[h-m];
    int lptr=0;
    int rptr=0;
    
    for(int i=l;i<=m;i++){
        left[lptr]=arr[i];
        lptr++;
    }
    for(int i=m+1;i<=h;i++){
        right[rptr]=arr[i];
        rptr++;
    }
    //showarr(left);
    //showarr(right);
    lptr=0;rptr=0;
    int i=l;
    while(lptr<(m-l+1)&&rptr<(h-m)){
       if(left[lptr]<right[rptr]){
            arr[i]=left[lptr];
            lptr++;
       }
       else{
            arr[i]=right[rptr];
            rptr++; 
       }
       i++;
    }
    while(lptr<(m-l+1)){
     arr[i]=left[lptr];
     lptr++;
     i++;
    }
    while(rptr<(h-m)){
       arr[i]=right[rptr];
       rptr++; 
       i++;
    }
}

void mergeSortSerial(int arr[SIZE],int l,int h){       
    if(l<h){
        int mid=(h+l)/2;
       // printf("L:%d M:%d H:%d\n",l,mid,h);
       // sleep(2);        
        mergeSortSerial(arr,l,mid);
        mergeSortSerial(arr,mid+1,h);
        merge(arr,l,mid,h);
    }
}

void ms(int arr[SIZE],int l,int h){
        
    if(l<h){
        int mid=(h+l)/2;
       // printf("L:%d M:%d H:%d\n",l,mid,h);
       // sleep(2);
        
        #pragma omp task
        {   
        ms(arr,l,mid);
        }
        #pragma omp task
        {
        ms(arr,mid+1,h);
        }
        #pragma omp taskwait
        merge(arr,l,mid,h);
    }
}


void mss(int arr[SIZE],int l,int h){
        
         if (h-l < 30) {
                mergeSortSerial(arr, l, h);
                return;
            }
    
    
    if(l<h){
        int mid=(h+l)/2;
       // printf("L:%d M:%d H:%d\n",l,mid,h);
       // sleep(2);
            #pragma omp task
                {   
                     mss(arr,l,mid);
                }   
                     mss(arr,mid+1,h);
            #pragma omp taskwait
            merge(arr,l,mid,h);
        
    }
}

int main(){

//#pragma omp parallel
//{
//printf("HEY4\n");
//}
    int arr[SIZE];//={1,5,3,6,8,2,6,8,22,0};
    setup(arr);
    printf("Inital:\n");
   // showarr(arr);
    int sorted = 1;
    int i;
	for (i = 0; i < SIZE-1; ++i) {
		sorted &= (arr[i] <= arr[i+1]);
	}
	printf("Array sorted: %d\n", sorted);
    //ms(arr,0,SIZE-1);
    //int mid=((SIZE-1)/2);
    //merge(arr,0,mid,SIZE-1);
    //teardown();
  //  showarr(arr);
    
    
    double start = omp_get_wtime(); 
    ms(arr, 0, SIZE-1); 
    double end = omp_get_wtime(); 
    double elapsed=end-start;
    printf("\nTime requried Parallel Tasking:%f \n",elapsed); 
    //showarr(arr);
    sorted = 1;
	for (i = 0; i < SIZE-1; ++i) {
		sorted &= (arr[i] <= arr[i+1]);
	}
	printf("Array sorted: %d\n", sorted);
    
    start = omp_get_wtime();     
    mergeSortSerial(arr, 0,SIZE-1); 
     end = omp_get_wtime();   
    elapsed=end-start;
    printf("\nTime requried Serial:%f \n",elapsed); 
 //  showarr(arr);
   sorted = 1;
	for (i = 0; i < SIZE-1; ++i) {
		sorted &= (arr[i] <= arr[i+1]);
	}
	printf("Array sorted: %d\n", sorted);
	
	
	start = omp_get_wtime();     
    #pragma omp parallel
    #pragma omp single
    mss(arr, 0,SIZE-1); 
     end = omp_get_wtime();   
    elapsed=end-start;
    printf("\nTime requried PARALLEL TASKING HYBRID:%f \n",elapsed); 
 //  showarr(arr);
   sorted = 1;
	for (i = 0; i < SIZE-1; ++i) {
		sorted &= (arr[i] <= arr[i+1]);
	}
	printf("Array sorted: %d\n", sorted);
    
return 0;
}

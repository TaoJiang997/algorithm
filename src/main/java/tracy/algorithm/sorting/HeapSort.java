package tracy.algorithm.sorting;

import java.util.Random;

/**
 * User: tracy
 * Date: 14-7-20
 * Time: 下午3:41
 */
public class HeapSort {


    public static void heapSort(int[] arr){
        if(arr==null || arr.length<=1){
            return;
        }
        buildMaxHeap(arr);
        for(int i=arr.length-1;i>=1;i--){
            swap(arr, 0, i);
            maxHeapify(arr, i, 0);
        }
    }

    //n*lg(n)
    public static void buildMaxHeap(int[] arr){
        if(arr==null || arr.length<=1){
            return;
        }
        int half = arr.length/2;
        for(int i=half;i>=0;i--){
            maxHeapify(arr,arr.length,i);
        }
    }



    //假定左右节点都是最大堆：lg(n)
    public static void maxHeapify(int[] arr,int heapSize,int index){
        int left = index*2+1;
        int right = index*2+2;

        int largest = index;
        if(left<heapSize && arr[left]>arr[index]){
            largest = left;
        }
        if(right<heapSize && arr[right]>arr[largest]){
            largest = right;
        }
        if(index!=largest){
            swap(arr,index,largest);
            maxHeapify(arr,heapSize,largest);
        }

    }


    private static void swap(int[] arr,int i ,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        Random random = new Random(47);
        int[] array = new int[20];
        for(int i=0;i<20;i++){
            array[i] = random.nextInt(100);
        }
        for(int i=0;i<20;i++){
            System.out.print(array[i] + " ");
        }
        System.out.println("\n");
        System.out.println("=====================================");
        heapSort(array);
        for(int i=0;i<20;i++){
            System.out.print(array[i] + " ");
        }
    }



}

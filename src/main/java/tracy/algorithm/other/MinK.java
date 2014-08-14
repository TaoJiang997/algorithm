package tracy.algorithm.other;

import tracy.algorithm.sorting.HeapSort;

/**
 * User: tracy
 * Date: 14-8-9
 * 查找最大的K个数
 */
public class MinK {
    public static void find(int[] arr,int k){
        if(arr.length<=k){
            printArray(arr) ;
        }
        int[] result = new int[k];
        for(int i=0;i<k;i++){
            result[i]=arr[i];
        }
        HeapSort.buildMaxHeap(result);
        for(int i=k;i<arr.length;i++){
            if(arr[i]<result[0]){
                result[0]=arr[i];
                HeapSort.maxHeapify(result,k,0);
            }
        }
        printArray(result);
    }

    private static void printArray(int[] arr){
        for(int i : arr){
            System.out.print(i + ",");
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,7,23,6,83,45};
        find(arr,8);
    }
}

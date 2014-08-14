package tracy.algorithm.sorting;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: tracy
 * Date: 14-7-16
 * Time: 下午11:07
 * To change this template use File | Settings | File Templates.
 */
public class MergeSort {


    private static int[] aux;


    public static void sort(int[] a){
        aux = new int[a.length];
        sort(a,0,a.length-1);
    }

    private static void sort(int[] a,int low,int high){
        if(high<=low) return;
        int mid = low + (high-low)/2;
        sort(a,low,mid);
        sort(a,mid+1,high);
        merge(a,low,mid,high);
    }

    public static void merge(int[] a, int low,int mid,int high){
        int i = low,j=mid+1;//a[low ... mid],a[mid+1 ... high]
        for(int k=low;k<=high;k++){
            aux[k] = a[k];
        }
        for(int k=low;k<=high;k++){
            if(i>mid){
                a[k]=aux[j++];
            }else if(j>high){
                a[k]=aux[i++];
            }else if(aux[i]<aux[j]){
                a[k]=aux[i++];
            }else {
                a[k]=aux[j++];
            }
        }
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
        sort(array);
        for(int i=0;i<20;i++){
            System.out.print(array[i] + " ");
        }
    }

}

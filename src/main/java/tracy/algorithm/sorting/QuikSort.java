package tracy.algorithm.sorting;

import java.util.Random;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: tracy
 * Date: 14-7-13
 * Time: 下午2:58
 * To change this template use File | Settings | File Templates.
 */
public class QuikSort {

    public static void sort(int[] a){
        sort(a,0,a.length-1);
    }

    public static void sortNoneRecurse(int[] a){
        Stack<Integer> startStack = new Stack<Integer>();
        Stack<Integer> endStack = new Stack<Integer>();
        int start = 0;
        int end = a.length-1;
        int pos;
        startStack.push(start);
        endStack.push(end);
        while(!startStack.isEmpty()){
            start = startStack.pop();
            end = endStack.pop();
            pos = partition(a,start,end);
            if(start<pos-1){
                startStack.push(start);
                endStack.push(pos-1);
            }
            if(end>pos+1){
                startStack.push(pos+1);
                endStack.push(end);
            }
        }
    }


    private static void sort(int[] a,int low,int high){
        if(high<low) return;
        int j = partition(a,low,high);
        sort(a,low,j-1);
        sort(a,j+1,high);
    }

    private static int partition(int[] a,int low,int high){
        int val = a[low];
        while(low<high){
            while(low<high && val <= a[high])
                high--;
            a[low]=a[high];
            while(low<high && val >= a[low])
                low++;
            a[high]=a[low];
        }
        a[low]=val;
        return low;
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
        sortNoneRecurse(array);
        for(int i=0;i<20;i++){
            System.out.print(array[i] + " ");
        }

    }


}

package tracy.algorithm.other;

/**
 * Created with IntelliJ IDEA.
 * User: tracy
 * Date: 14-7-17
 * Time: 下午11:35
 * To change this template use File | Settings | File Templates.
 */
public class Permutation {
    private static int n;

    public static void perm(int[] arr,int start,int end){
        if(start==end){
            for(int i=0;i<=end;i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println("\n");
            n++;
        }else{
            for(int i=start;i<=end;i++){
                swap(arr,start,i);
                perm(arr,start+1,end);
                swap(arr,start,i);
            }
        }
    }

    private static void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int len = 3;
        int[] arr = new int[len];
        for (int i =0;i<len;i++){
            arr[i]=i+1;
        }

        perm(arr,0,arr.length-1);
        System.out.println(n);
    }
}

package tracy.algorithm.string;

/**
 * User: tracy
 * Date: 14-7-17
 * 求1~n的全排列
 */
public class Permutation {
    private static int n;

    public static void perm(int[] arr,int start,int end){
        if(start==end){
            for(int i=0;i<=end;i++){
                System.out.print(arr[i] + " ");
            }
            System.out.println("\n");
            n++;
            return;
        }
        for(int i=start;i<=end;i++){
            swap(arr,start,i);
            perm(arr,start+1,end);
            swap(arr,start,i);
        }
    }

    public static void perm2(int[] arr,int length,int start){
        if(start==length-1){
            for(int i=0;i<length;i++){
                System.out.print(arr[i] + " ");
            }
            System.out.println("\n");
            n++;
            return;
        }
        for(int j=start;j<length;j++){
            swap(arr,start,j);
            perm2(arr,length,start+1);
            swap(arr,start,j);
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

        perm2(arr, arr.length,0);
        System.out.println(n);
    }
}

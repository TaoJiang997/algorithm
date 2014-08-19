package tracy.algorithm.other;

/**
 * User: tracy
 * Date: 14-8-20
 * 奇数在偶数前
 */
public class OddBeforeEven {
    public static int[] sort(int[] arr){
        if(arr==null || arr.length==0){
            return null;
        }
        int low = 0,high = arr.length-1;
        while(low<high){
            if(isOdd(low)){
                low++;
                continue;
            }
            if(!isOdd(high)){
                high--;
                continue;
            }
            swap(arr,low,high);
            low++;
            high--;
        }
        return arr;
    }

    //奇数
    private static boolean isOdd(int i){
        return (i&1)==0;
    }

    private static void swap(int[] arr,int low,int high){
        int tmp = arr[low];
        arr[low]=arr[high];
        arr[high]=tmp;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        sort(arr);
        for(int i : arr){
            System.out.print(i+",");
        }
    }
}

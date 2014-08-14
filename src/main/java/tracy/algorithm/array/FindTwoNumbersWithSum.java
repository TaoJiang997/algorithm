package tracy.algorithm.array;

/**
 * Created with IntelliJ IDEA.
 * User: tracy
 * Date: 14-8-12
 * Time: 下午9:46
 * To change this template use File | Settings | File Templates.
 */
public class FindTwoNumbersWithSum {

    public static void find(int[] arr,int sum){
        if(arr==null || arr.length<=1){
            System.out.println("not find");
        }

        int low=0,high = arr.length-1;
        while(low<high){
            if(arr[low]+arr[high]==sum){
                System.out.println(arr[low]+","+arr[high]);
                break;
            }else if(arr[low]+arr[high]>sum){
                high--;
            }else{
                low++;
            }
        }


    }

    public static void main(String[] args) {
        int[] arr = {1,3,5,7,9,13,15,17,18,20};
        find(arr,24);
    }


}

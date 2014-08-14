package tracy.algorithm.other;

/**
 * Created with IntelliJ IDEA.
 * User: tracy
 * Date: 14-7-28
 * Time: 下午11:55
 * To change this template use File | Settings | File Templates.
 */
public class IncreaseAndDecreaseSearch {
    public static int top(int[] arr){
        int len = arr.length;
        int start = 0;
        int end = len-1;
        int mid = start + (end-start)/2;
        while(mid>0 && mid<len-1){
            if(arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1]){
                return mid;
            }else if(arr[mid]>arr[mid-1] && arr[mid]<arr[mid+1]){
                mid = mid + (end-mid)/2;
            }else if(arr[mid]<arr[mid-1] && arr[mid]>arr[mid+1]){
                mid = start + (mid-start)/2;
            }
        }
        return -1;
    }

    private static int incBinarySearch(int[] arr,int start,int end,int val){
        int mid;
        while(start<=end){
            mid = start + (end-start)/2;
            if(arr[mid]==val)
                return mid;
            else if(arr[mid]>val){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return -1;
    }

    private static int descBinarySearch(int[] arr,int start,int end,int val){
        int mid;
        while(start<=end){
            mid = start + (end-start)/2;
            if(arr[mid]==val)
                return mid;
            else if(arr[mid]>val){
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return -1;
    }

    public static int search(int[] arr,int val){
        int top = top(arr);
        int pos = incBinarySearch(arr,0,top,val);
        if(pos>=0)
            return pos;
        pos = descBinarySearch(arr,top+1,arr.length-1,val);
        if(pos>=0)
            return pos;
        return -1;
    }

    public static void main(String[] args) {
        int[] arr ={1,3,5,7,9,10,8,7,6,4,2,0};
        System.out.println(search(arr,3));
    }

}

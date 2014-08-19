package tracy.algorithm.bitwise;

/**
 * Created with IntelliJ IDEA.
 * User: tracy
 * Date: 14-8-20
 * Time: 上午1:00
 * To change this template use File | Settings | File Templates.
 */
public class SingleNumber {
    public static int find(int[] A) {
        if(A.length==1)
            return A[0];
        for(int i=A.length-1;i>=1;i--){
            A[0] = A[0] ^ A[i];
        }
        return A[0];
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,1,3,4,5};
        System.out.println(find(arr));
    }

}

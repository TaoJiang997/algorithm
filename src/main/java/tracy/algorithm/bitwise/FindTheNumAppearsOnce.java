package tracy.algorithm.bitwise;

/**
 * User: tracy
 * Time: 2015/4/6 20:49
 * LeetCode 136.Single Number
 * Given an array of integers, every element appears twice except for one. Find that single one.
 */
public class FindTheNumAppearsOnce {
    public int find(int[] A) {
        if(A.length==1)
            return A[0];
        for(int i=A.length-1;i>=1;i--){
            A[0] = A[0] ^ A[i];
        }
        return A[0];
    }
}

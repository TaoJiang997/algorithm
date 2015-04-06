package tracy.algorithm.dp;

/**
 * User: tracy
 * Time: 2015/4/6 21:33
 * LeetCode 96.Unique Binary Search Trees
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 */
public class NumberOfUniqueBinarySearchTrees {
    public int numTrees(int n) {
        if(n==1||n==0)
            return 1;
        int result = 0;
        for(int i=1;i<=n;i++){
            result+=numTrees(i-1)*numTrees(n-i);
        }
        return result;
    }
}

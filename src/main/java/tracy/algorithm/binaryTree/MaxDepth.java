package tracy.algorithm.binaryTree;

/**
 * User: tracy
 * Date: 14-8-20
 * Time: 上午12:05
 * LeetCode 104.Maximum Depth of Binary Tree
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */
public class MaxDepth {

    public static int maxDepth(TreeNode root){
        if(root==null)
            return 0;
        TreeNode left = root.left;
        TreeNode right = root.right;
        return 1 + Math.max(maxDepth(left),maxDepth(right));
    }

    public static void main(String[] args) {
        System.out.println(maxDepth(TreeNode.of()));
    }
}

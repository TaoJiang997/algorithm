package tracy.algorithm.binaryTree;

/**
 * Created with IntelliJ IDEA.
 * User: tracy
 * Date: 14-8-4
 * Time: 上午8:38
 * To change this template use File | Settings | File Templates.
 */
public class Balanced {
    public boolean isBalanced(TreeNode root){
        return maxDepth(root)!=-1;
    }
    private int maxDepth(TreeNode node){
        if(node == null){
            return 0;
        }
        int left = maxDepth(node.left);
        int right = maxDepth(node.right);
        if(left==-1||right==-1||Math.abs(left-right)>-1){
            return -1;
        }
        return Math.max(left,right)+1;
    }
}

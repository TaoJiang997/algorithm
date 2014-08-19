package tracy.algorithm.binaryTree;

/**
 * Created with IntelliJ IDEA.
 * User: tracy
 * Date: 14-8-20
 * Time: 上午12:05
 * To change this template use File | Settings | File Templates.
 */
public class Depth {

    public static int depth(TreeNode node){
        if(node==null){
            return 0;
        }
        int leftDepth = depth(node.left);
        int rightDepth = depth(node.right);
        return leftDepth>rightDepth?(leftDepth+1):(rightDepth+1);
    }

    public static void main(String[] args) {
        System.out.println(depth(TreeNode.of()));
    }
}

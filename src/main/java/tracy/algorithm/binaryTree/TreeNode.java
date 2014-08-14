package tracy.algorithm.binaryTree;

/**
 * Created with IntelliJ IDEA.
 * User: tracy
 * Date: 14-8-4
 * Time: 上午7:43
 * To change this template use File | Settings | File Templates.
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode prev;
    TreeNode next;
    TreeNode(int x){val=x;}




    /*
            10
           /   \
          6    14
         / \  / \
        4  8 12 16
     */
    public static TreeNode of(){
        TreeNode root = new TreeNode(10);
        TreeNode second = new TreeNode(6);
        TreeNode third = new TreeNode(14);
        TreeNode fourth = new TreeNode(4);
        TreeNode fifth = new TreeNode(8);
        TreeNode sixth = new TreeNode(12);
        TreeNode seventh = new TreeNode(16);

        root.left = second;
        root.right = third;

        second.left = fourth;
        second.right = fifth;

        third.left = sixth;
        third.right = seventh;
        return root;
    }

    /*
             10
           /   \
          5     12
        /   \
     　4     7
     */
    public static TreeNode of2(){
        TreeNode root = new TreeNode(10);
        TreeNode second = new TreeNode(5);
        TreeNode third = new TreeNode(12);
        TreeNode fourth = new TreeNode(4);
        TreeNode fifth = new TreeNode(7);
        root.left = second;
        root.right = third;

        second.left = fourth;
        second.right = fifth;
        return root;
    }
}

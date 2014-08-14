package tracy.algorithm.binaryTree;

import java.util.Stack;

/**
 * User: tracy
 * Date: 14-8-12
 * 镜像二叉树
 */
public class Mirror {


    public static  void recursive(TreeNode root){
        if(root==null){
            return;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = right;
        root.right = left;
        recursive(left);
        recursive(right);
    }

    public static void nonRecursive(TreeNode root){
        if(root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        while(!stack.isEmpty()){
            root = stack.pop();
            TreeNode left = root.left;
            TreeNode right = root.right;
            root.left = right;
            root.right = left;
            if(left!=null){
                stack.push(left);
            }
            if(right!=null){
                stack.push(right);
            }
        }
    }


    public static void main(String[] args) {
        TreeNode root = TreeNode.of2();
        recursive(root);
        PrintFromTopToBottom.print(root);
    }
}

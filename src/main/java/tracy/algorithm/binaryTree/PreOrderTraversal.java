package tracy.algorithm.binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: tracy
 * Date: 14-8-4
 * Time: 上午7:41
 * To change this template use File | Settings | File Templates.
 */
public class PreOrderTraversal {

    public List<Integer> preOrder(TreeNode root){
        List<Integer> result = new ArrayList<Integer>();
        if(root==null){
            return result;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()){
            root = stack.pop();
            result.add(root.val);
            if(root.right!=null){
                stack.push(root.right);
            }
            if(root.left!=null){
                stack.push(root.left);
            }
        }
        return result;
    }

    public List<Integer> recursive(TreeNode root){
        List<Integer> result = new ArrayList<Integer>();
        travel(root,result);
        return result;
    }

    private void travel(TreeNode node,List<Integer> result){
        while(node!=null){
            result.add(node.val);
            travel(node.left,result);
            travel(node.right,result);
        }
    }


}

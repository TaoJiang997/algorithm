package tracy.algorithm.binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: tracy
 * Date: 14-8-4
 * Time: 上午8:21
 * To change this template use File | Settings | File Templates.
 */
public class PostOrderTraversal {
    public List<Integer> postOrder(TreeNode root){
        List<Integer> result = new ArrayList<Integer>();
        if(root==null){
            return result;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        TreeNode cur;
        TreeNode prev = null;
        while (!stack.isEmpty()){
            cur = stack.lastElement();
            if((cur.left==null && cur.right==null)||(prev!=null&&(prev==cur.left||prev==cur.right))){
                stack.pop();
                result.add(cur.val);
                prev = cur;
            }else{
                if(cur.right!=null){
                    stack.push(cur.right);
                }
                if(cur.left!=null){
                    stack.push(cur.left);
                }
            }
        }
        return result;
    }
}

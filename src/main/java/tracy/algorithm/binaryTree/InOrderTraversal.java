package tracy.algorithm.binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * User: tracy
 * Date: 14-8-4
 */
public class InOrderTraversal {

    public List<Integer> inOrder(TreeNode root){
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if(root==null)
            return result;
        stack.push(root);
        TreeNode cur = root.left;
        while(cur!=null || !stack.isEmpty()){
            while(cur!=null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            result.add(cur.val);
            cur = cur.right;
        }
        return result;

    }

}

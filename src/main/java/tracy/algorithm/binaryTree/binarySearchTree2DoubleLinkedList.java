package tracy.algorithm.binaryTree;

import java.util.Stack;

/**
 * User: tracy
 * Date: 14-8-5
 * 二元查找树转换为双向链表.
 */
public class binarySearchTree2DoubleLinkedList {

    public static TreeNode convert(TreeNode root){
        if(root==null){
            return root;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        TreeNode cur = root.left;
        boolean first = true;
        TreeNode result = null;
        TreeNode prev = null;
        while(cur!=null || !stack.isEmpty()){
            while (cur!=null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if(first){
                result = prev = cur;
                first = false;
            }else {
                prev.next = cur;
                cur.prev= prev;
                prev = cur;
            }
            cur = cur.right;
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode first = convert(TreeNode.of());
        TreeNode last = first;
//        while(first!=null){
//            System.out.print(first.val);
//            System.out.print("==");
//            first = first.next;
//        }

        while(last.next!=null){
            last = last.next;
        }

        while(last!=null){
            System.out.print(last.val);
            System.out.print("==");
            last = last.prev;
        }
    }

}

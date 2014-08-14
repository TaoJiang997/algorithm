package tracy.algorithm.binaryTree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * User: tracy
 * Date: 14-8-12
 * 从上往下，从左往右打印
 */
public class PrintFromTopToBottom {

    public static void print(TreeNode root){
        if(root==null){
            return;
        }

        Deque<TreeNode> deque = new ConcurrentLinkedDeque<TreeNode>();
        List<Integer> list = new ArrayList<Integer>();
        deque.addFirst(root);
        while(!deque.isEmpty()){
            root = deque.pollFirst();
            list.add(root.val);
            if(root.left!=null){
                deque.addLast(root.left);
            }
            if(root.right!=null){
                deque.addLast(root.right);
            }
        }
        for(int i : list){
            System.out.print(i+",");
        }
    }

    public static void main(String[] args) {
        print(TreeNode.of());
    }

}

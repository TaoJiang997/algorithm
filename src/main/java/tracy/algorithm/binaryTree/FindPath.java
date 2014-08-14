package tracy.algorithm.binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * User: tracy
 * Date: 14-8-9
 * 输入一个整数和一棵二元树。从树的根结点开始往下访问一直到叶结点所经过的所有结点形成一条路径。
 * 打印出和与输入整数相等的所有路径
 */
public class FindPath {


    public static void find(TreeNode node,int val,int sum,List<Integer> list,Stack<TreeNode> stack){
        if(node==null){
            return;
        }
        sum+=node.val;
        list.add(node.val);
        stack.push(node);
        if(sum==val && node.left==null && node.right==null){
            printList(list);
        }
        TreeNode left = node.left;
        if(left!=null){
            find(left,val,sum,list,stack);
        }
        TreeNode right = node.right;
        if(right!=null){
            find(right,val,sum,list,stack);
        }
        sum-=node.val;
        list.remove(list.size()-1);
        stack.pop();
    }

    private static void printList(List<Integer> list){
        for(int i : list){
            System.out.print(i + ",");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        find(TreeNode.of2(), 22, 0, new ArrayList<Integer>(),new Stack<TreeNode>());
    }
}

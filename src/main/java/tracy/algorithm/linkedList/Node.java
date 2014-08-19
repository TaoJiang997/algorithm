package tracy.algorithm.linkedList;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: tracy
 * Date: 14-8-12
 * Time: 下午9:20
 * To change this template use File | Settings | File Templates.
 */
public class Node {
    int val;
    Node next;
    public Node(int val){
        this.val = val;
        this.next = null;
    }

    public static Node of(){
        Node head = new Node(0);
        Node cur = head;
        for(int i=1;i<10;i++){
            Node next = new Node(i);
            cur.next = next;
            cur = next;
        }
        return head;
    }

    public static void print(Node node){
        while (node!=null){
            System.out.print(node.val+",");
            node = node.next;
        }
    }
}

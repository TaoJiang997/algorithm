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

    public static Node[] twoIntersect(){
        Node head1  = new Node(0);
        Node cur1 = head1;
        for(int i=1;i<3;i++){
            Node next = new Node(i);
            cur1.next = next;
            cur1 = next;
        }
        Node head2  = new Node(0);
        Node cur2 = head2;
        for(int i=3;i<10;i++){
            Node next = new Node(i);
            cur2.next = next;
            cur2 = next;
        }

        for(int i=15;i<20;i++){
            Node next = new Node(i);
            cur1.next = next;
            cur2.next = next;
            cur1 = next;
            cur2 = next;
        }

        Node[] result = new Node[2];
        result[0] = head1;
        result[1] = head2;
        return result;
    }

    public static Node[] twoSeperate(){
        Node head1  = new Node(0);
        Node cur1 = head1;
        for(int i=1;i<3;i++){
            Node next = new Node(i);
            cur1.next = next;
            cur1 = next;
        }
        Node head2  = new Node(0);
        Node cur2 = head2;
        for(int i=3;i<10;i++){
            Node next = new Node(i);
            cur2.next = next;
            cur2 = next;
        }
        Node[] result = new Node[2];
        result[0] = head1;
        result[1] = head2;
        return result;
    }


    public static void print(Node node){
        while (node!=null){
            System.out.print(node.val+",");
            node = node.next;
        }
    }


    public static int len(Node node){
        if(node==null){
            return 0;
        }
        int i=0;
        while(node!=null){
            i++;
            node = node.next;
        }
        return i;
    }
}

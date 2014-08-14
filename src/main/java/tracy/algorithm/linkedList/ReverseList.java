package tracy.algorithm.linkedList;

/**
 * Created with IntelliJ IDEA.
 * User: tracy
 * Date: 14-8-13
 * Time: 下午11:16
 * To change this template use File | Settings | File Templates.
 */
public class ReverseList {

    public static Node reverse(Node node){
        if(node==null){
            return null;
        }

        Node head = null;
        Node cur = node;
        Node prev = null;
        while(cur!=null){
            Node pnext = cur.next;
            cur.next = prev;
            if(pnext==null){
                head = cur;
            }
            prev = cur;
            cur = pnext;
        }
        return head;
    }

    public static void main(String[] args) {
        Node node = Node.of();
        node = reverse(node);
        while (node!=null){
            System.out.print(node.val+",");
            node = node.next;
        }
    }
}

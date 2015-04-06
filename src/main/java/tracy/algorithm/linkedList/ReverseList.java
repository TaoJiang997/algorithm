package tracy.algorithm.linkedList;

/**
 * Created with IntelliJ IDEA.
 * User: tracy
 * Date: 14-8-13
 * Time: 下午11:16
 * To change this template use File | Settings | File Templates.
 */
public class ReverseList {

    public static ListNode reverse(ListNode node){
        if(node==null){
            return null;
        }

        ListNode head = null;
        ListNode cur = node;
        ListNode prev = null;
        while(cur!=null){
            ListNode pnext = cur.next;
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
        ListNode node = ListNode.of();
        node = reverse(node);
        while (node!=null){
            System.out.print(node.val+",");
            node = node.next;
        }
    }
}

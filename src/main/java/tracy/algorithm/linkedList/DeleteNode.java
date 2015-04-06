package tracy.algorithm.linkedList;

/**
 * User: tracy
 * Date: 14-8-20
 * 给定链表的头指针和一个结点指针，在O(1)时间删除该结点
 */
public class DeleteNode {

    public static ListNode delete(ListNode head,ListNode target){
        if(head==null || target==null){
            return head;
        }
        if(target.next!=null){
            target.val = target.next.val;
            target.next = target.next.next;
        }else{
            if(target == head){
                return null;
            }else{
                ListNode cur = head;
                while (cur.next != target){
                    cur = cur.next;
                }
                cur.next = null;
            }
        }
        return head;
    }


    public static void main(String[] args) {
        ListNode head = ListNode.of();
        head = delete(head,head);
        ListNode.print(head);
        System.out.println("");
        ListNode next = head.next;
        head = delete(head,next);
        ListNode.print(head);
        System.out.println("");
        while(next.next!=null){
            next = next.next;
        }
        ListNode.print(delete(head, next));

        while(next!=null){
            next = next.next;
        }

    }
}

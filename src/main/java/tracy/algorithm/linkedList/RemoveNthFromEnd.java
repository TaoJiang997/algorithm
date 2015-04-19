package tracy.algorithm.linkedList;

/**
 * User: tracy
 * Time: 2015/4/19 21:22
 * LeetCode 19.Remove Nth Node From End of List
 * Given a linked list, remove the nth node from the end of list and return its head.
     For example,
     Given linked list: 1->2->3->4->5, and n = 2.
     After removing the second node from the end, the linked list becomes 1->2->3->5.
     Note:
     Given n will always be valid.
     Try to do this in one pass.
 */
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || n==0)
            return head;
        if(n==1 && head.next==null)
            return null;
        ListNode fast=head,slow=head;
        for(int i=0;i<n;i++){
            if(fast!=null)
                fast = fast.next;
            else
                return head;
        }
        if(fast==null){
            head = head.next;
            return head;
        }
        while(fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}

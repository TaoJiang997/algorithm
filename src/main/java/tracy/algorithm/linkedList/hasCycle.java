package tracy.algorithm.linkedList;

/**
 * User: tracy
 * Time: 2015/4/6 21:37
 * LeetCode 144.Linked List Cycle
 * Given a linked list, determine if it has a cycle in it.
 */
public class hasCycle {
    public boolean hasCycle(ListNode head) {
        if(head == null)
            return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while(slow!=null && fast!=null){
            if(fast.next==null)
                break;
            fast = fast.next.next;
            slow = slow.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }
}

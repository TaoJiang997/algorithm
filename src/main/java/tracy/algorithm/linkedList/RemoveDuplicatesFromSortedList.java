package tracy.algorithm.linkedList;

/**
 * User: tracy
 * Time: 2015/4/6 21:49
 * LeetCode 83.Remove Duplicates from Sorted List
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
     For example,
     Given 1->1->2, return 1->2.
     Given 1->1->2->3->3, return 1->2->3.
 */
public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        if(head==null)
            return head;
        ListNode next = head.next;
        while(next!=null){
            if(cur.val==next.val){
                cur.next = next.next;
                next = next.next;
            }else{
                cur = next;
                next = next.next;
            }
        }
        return head;
    }
}

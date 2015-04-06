package tracy.algorithm.linkedList;

/**
 * User: tracy
 * Time: 2015/4/6 21:52
 * LeetCode 21.Merge Two Sorted Lists
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null && l2==null){
            return null;
        }

        if(l2==null){
            return l1;
        }
        if(l1==null){
            return l2;
        }
        ListNode root ;
        ListNode end ;
        if(l1.val<l2.val){
            root = l1;
            l1 = l1.next;
        }else{
            root = l2;
            l2 = l2.next;
        }
        end = root;
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                end.next = l1;
                end = end.next;
                l1 = l1.next;
            }else{
                end.next = l2;
                end = end.next;
                l2 = l2.next;
            }
        }
        if(l1!=null){
            end.next = l1;
        }else if(l2!=null){
            end.next = l2;
        }
        return root;
    }
}

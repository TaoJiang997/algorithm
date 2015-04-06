package tracy.algorithm.linkedList;

/**
 * Created with IntelliJ IDEA.
 * User: tracy
 * Date: 14-8-12
 * Time: 下午9:20
 * To change this template use File | Settings | File Templates.
 */
public class ListNode {
    int val;
    ListNode next;
    public ListNode(int val){
        this.val = val;
        this.next = null;
    }

    public static ListNode of(){
        ListNode head = new ListNode(0);
        ListNode cur = head;
        for(int i=1;i<10;i++){
            ListNode next = new ListNode(i);
            cur.next = next;
            cur = next;
        }
        return head;
    }

    public static ListNode[] twoIntersect(){
        ListNode head1  = new ListNode(0);
        ListNode cur1 = head1;
        for(int i=1;i<3;i++){
            ListNode next = new ListNode(i);
            cur1.next = next;
            cur1 = next;
        }
        ListNode head2  = new ListNode(0);
        ListNode cur2 = head2;
        for(int i=3;i<10;i++){
            ListNode next = new ListNode(i);
            cur2.next = next;
            cur2 = next;
        }

        for(int i=15;i<20;i++){
            ListNode next = new ListNode(i);
            cur1.next = next;
            cur2.next = next;
            cur1 = next;
            cur2 = next;
        }

        ListNode[] result = new ListNode[2];
        result[0] = head1;
        result[1] = head2;
        return result;
    }

    public static ListNode[] twoSeperate(){
        ListNode head1  = new ListNode(0);
        ListNode cur1 = head1;
        for(int i=1;i<3;i++){
            ListNode next = new ListNode(i);
            cur1.next = next;
            cur1 = next;
        }
        ListNode head2  = new ListNode(0);
        ListNode cur2 = head2;
        for(int i=3;i<10;i++){
            ListNode next = new ListNode(i);
            cur2.next = next;
            cur2 = next;
        }
        ListNode[] result = new ListNode[2];
        result[0] = head1;
        result[1] = head2;
        return result;
    }


    public static void print(ListNode node){
        while (node!=null){
            System.out.print(node.val+",");
            node = node.next;
        }
    }


    public static int len(ListNode node){
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

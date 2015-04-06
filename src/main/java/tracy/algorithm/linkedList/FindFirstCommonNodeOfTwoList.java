package tracy.algorithm.linkedList;

/**
 * Created with IntelliJ IDEA.
 * User: tracy
 * Date: 14-9-15
 * Time: 下午10:12
 * To change this template use File | Settings | File Templates.
 */
public class FindFirstCommonNodeOfTwoList {

    public static ListNode find(ListNode head1,ListNode head2){
        if(head1==null || head2==null){
            return null;
        }

        int len1= ListNode.len(head1);
        int len2 = ListNode.len(head2);

        if(len1<len2){
            ListNode tmp = head1;
            head1 = head2;
            head2 = tmp;
        }//head1.length >= head2.length

        int len = Math.abs(len1-len2);

        for(int i=0;i<len;i++){
            head1 = head1.next;
        }

        while(head1!=null && head2!=null && head1!=head2){
            head1 = head1.next;
            head2 = head2.next;
        }

        if(head1==head2 && head1!=null){
            return head1;
        }
        return null;
    }


    public static void main(String[] args) {
        //Node[] nodes = Node.twoIntersect();
        ListNode[] nodes = ListNode.twoSeperate();
        ListNode node = find(nodes[0],nodes[1]);
        if(node!=null){
            System.out.println(node.val);
        }else{
            System.out.println("No same node!");
        }
    }

}

package tracy.algorithm.linkedList;

/**
 * User: tracy
 * Date: 14-8-20
 */
public class PrintListReversely {

    public static void print(ListNode node){
        if(node!=null){
            if(node.next!=null){
                print(node.next);
            }
            System.out.print(node.val+",");
        }
    }

    public static void main(String[] args) {
        print(ListNode.of());
    }
}

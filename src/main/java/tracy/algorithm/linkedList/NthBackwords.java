package tracy.algorithm.linkedList;


/**
 * User: tracy
 * Date: 14-8-12
 * 倒数第N个元素
 */
public class NthBackwords {
    public static Node find(Node node,int n){
        if(node==null){
            return null;
        }

        Node fast = node;
        Node slow = null;
        for(int i=1;i<n;i++){
            if(fast.next!=null){
                fast =  fast.next;
            }else{
                return null;
            }
        }

        slow = node;

        while(fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        System.out.println(find(Node.of(),2).val);
    }

}

package tracy.algorithm.stack;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: tracy
 * Date: 14-8-17
 * Time: 下午4:54
 * To change this template use File | Settings | File Templates.
 */
public class IsPossiblePopOrder {
    public static boolean isPossible(int[] original,int[] popOrder){
        Stack<Integer> stack = new Stack();
        int i = 0,j=0;
        int olen = original.length;
        int plen = popOrder.length;
        while ((i<olen || !stack.isEmpty()) && j<plen){
            if(i<olen && popOrder[j]==original[i]){
                i++;
                j++;
            }else if(!stack.isEmpty()){
                if(popOrder[j]==stack.peek()){
                    stack.pop();
                    j++;
                }else{
                    if(i<olen){
                        stack.push(original[i]);
                        i++;
                    }else{
                        return false;
                    }
                }
            }else{
                if(i<olen){
                    stack.push(original[i]);
                    i++;
                }else{
                    return false;
                }
            }
        }
        if(j==plen)
            return true;
        return false;
    }


    public static void main(String[] args) {
        int[] original = {1,2,3,4,5};
        int[] popOrder = {3,4,5,1,2};
        System.out.println(isPossible(original,popOrder));
    }
}

package tracy.algorithm.stack;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: tracy
 * Date: 14-8-13
 * Time: 下午11:02
 * To change this template use File | Settings | File Templates.
 */
public class QueueWithTwoStack {

    public void push(Object obj){
        stackOne.push(obj);
    }

    public Object pop(){
        if(!stackTwo.isEmpty()){
            return stackTwo.pop();
        }else{
            while(!stackOne.isEmpty()){
                stackTwo.push(stackOne.pop());
            }
            if(!stackTwo.isEmpty()){
                return stackTwo.pop();
            }else{
                throw new EmptyStackException();
            }
        }
    }


    private Stack<Object> stackOne;
    private Stack<Object> stackTwo;




}

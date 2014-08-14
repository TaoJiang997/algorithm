package tracy.algorithm.stack;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: tracy
 * Date: 14-8-5
 * Time: 下午11:52
 * To change this template use File | Settings | File Templates.
 */
public class MinStack {
    private Stack<Integer> data = new Stack<Integer>();
    private Stack<Integer> pos = new Stack<Integer>();
    public void push(int val){
        if(data.isEmpty()){
            data.push(val);
            pos.push(0);
        }else{
            data.push(val);
            int minPos = pos.peek();
            int min = data.get(minPos);
            if(min<val){
                pos.push(minPos);
            }else{
                pos.push(data.size()-1);
            }
        }
    }

    public int pop(){
        pos.pop();
        return data.pop();
    }

    public int peek(){
        return data.peek();
    }

    public int min(){
        return data.get(pos.peek());
    }


    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<data.size();i++){
            sb.append(data.get(i));
            if(i!=(data.size()-1)){
                sb.append(",");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        MinStack ms = new MinStack();
        ms.push(3);
        System.out.println(ms.toString() + "   ------------   " + ms.min());
        ms.push(4);
        System.out.println(ms.toString() + "   ------------   " + ms.min());
        ms.push(2);
        System.out.println(ms.toString() + "   ------------   " + ms.min());
        ms.push(1);
        System.out.println(ms.toString() + "   ------------   " + ms.min());
        ms.pop();
        System.out.println(ms.toString() + "   ------------   " + ms.min());
        ms.pop();
        System.out.println(ms.toString() + "   ------------   " + ms.min());
        ms.push(0);
        System.out.println(ms.toString() + "   ------------   " + ms.min());
    }
}

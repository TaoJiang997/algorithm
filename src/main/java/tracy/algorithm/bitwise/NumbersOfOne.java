package tracy.algorithm.bitwise;

/**
 * Created with IntelliJ IDEA.
 * User: tracy
 * Date: 14-8-17
 * Time: 下午3:56
 * To change this template use File | Settings | File Templates.
 */
public class NumbersOfOne {
    public static int caculate(int val){
        int flag = 1;
        int count = 0;
        while(flag>0){
            if((val & flag) != 0){
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(caculate(-1));
    }
}

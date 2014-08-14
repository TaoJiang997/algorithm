package tracy.algorithm.dp;

/**
 * Created with IntelliJ IDEA.
 * User: tracy
 * Date: 14-8-2
 * Time: 下午2:41
 * To change this template use File | Settings | File Templates.
 */
public class OneOrTwoStep {
    public static int climbStairs(int n) {
        if(n==0)
            return 0;
        if(n==1)
            return 1;
        if(n==2)
            return 2;
        return climbStairs(n-1)+climbStairs(n-2);
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(44));
    }
}

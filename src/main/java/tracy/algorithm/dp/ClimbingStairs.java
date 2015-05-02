package tracy.algorithm.dp;

/**
 * User: tracy
 * Date: 14-8-2
 * Time: 下午2:41
 * LeetCode 70.Climbing Stairs
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
public class ClimbingStairs {
    public static int climbStairs(int n) {
        if(n<0)
            throw new RuntimeException("the input n should be >=0");
        if(n<=2)
            return n;
        return climbStairs(n-1)+climbStairs(n-2);
    }

    public static int climbStairs2(int n) {
        if(n<=2)
            return n;
        int one = 2; int two = 1;
        for(int i=3;i<=n;i++){
            int tmp = one;
            one = one+two;
            two = tmp;
        }
        return one;
    }
    public static void main(String[] args) {
        System.out.println(climbStairs(44));
    }
}

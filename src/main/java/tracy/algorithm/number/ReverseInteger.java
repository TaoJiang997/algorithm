package tracy.algorithm.number;

/**
 * User: tracy
 * Time: 2015/4/6 22:06
 * Reverse digits of an integer.
     Example1: x = 123, return 321
     Example2: x = -123, return -321
 */
public class ReverseInteger {
    public int reverse(int x) {
        int a = 1;
        if(x<0){
            a=-1;
            x = -x;
        }
        if(x<10){
            return x*a;
        }
        int result = 0;
        while(x>=10){
            result = (result + x%10)*10;
            x=x/10;
        }
        return (result+x)*a;
    }
}

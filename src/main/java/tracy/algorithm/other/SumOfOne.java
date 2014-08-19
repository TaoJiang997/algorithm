package tracy.algorithm.other;

/**
 * User: tracy
 * Date: 14-8-19
 * Time: 下午11:29
 * 给出一个数n，求1~n所有数中，1出现的次数
 *
 */
public class SumOfOne {

    public static int caculate(int n){
        int count=0;
        int lower = 0;
        int cur = 0;
        int higher = 0;
        int factor = 1;
        while(n/factor>0){
            lower = n%factor;
            cur = (n/factor)%1;
            higher = n/(factor*10);
            switch (cur){
                case 0:
                    count+=higher*factor;
                    break;
                case 1:
                    count+=higher*factor+lower+1;
                    break;
                default:
                    count+=(higher+1)*factor;
            }
            factor*=10;
        }
        return count;
    }

}












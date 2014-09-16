package tracy.algorithm.other;

/**
 * Created with IntelliJ IDEA.
 * User: tracy
 * Date: 14-9-17
 * Time: 上午12:28
 * To change this template use File | Settings | File Templates.
 */
public class FindUglyNumber {


    public static boolean isUgly(int number){
        while (number%2 == 0)
            number /= 2;
        while (number%3 == 0)
            number /= 3;
        while (number%5 == 0)
            number /= 5;
        return number == 1;
    }

    public static int findNthUglyNumber(int index){
        if(index<=0)
            return 0;
        int number = 0;
        int uglyIndex = 0;
        while (uglyIndex < index){
            number++;
            if(isUgly(number)){
                uglyIndex++;
            }
        }
        return number;
    }


    public static int quickFindNthUglyNumber(int index){
        if(index<=0)
            return 0;
        int[] uglyNumbers = new int[index];
        int[] multiple2 = new int[index];
        int[] multiple3 = new int[index];
        int[] multiple5 = new int[index];

        uglyNumbers[0] = multiple2[0] = multiple3[0] = multiple5[0] = 1;
        int nextUglyIndex = 1;

        while (nextUglyIndex<index){
            int val = uglyNumbers[nextUglyIndex-1];
            int i = 0;
            int tmp2 = uglyNumbers[i]*2;
            while(tmp2<=val){
                tmp2 = uglyNumbers[++i]*2;
            }

            i = 0;
            int tmp3 = uglyNumbers[i]*3;
            while (tmp3<=val){
                tmp3 = uglyNumbers[++i]*3;
            }

            i = 0;
            int tmp5 = uglyNumbers[i]*5;
            while (tmp5<=val){
                tmp5 = uglyNumbers[++i]*5;
            }

            uglyNumbers[nextUglyIndex++] = Math.min(tmp2,Math.min(tmp3,tmp5));
        }
        return uglyNumbers[uglyNumbers.length-1];

    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(findNthUglyNumber(1500));
        System.out.println("cost : " + (System.currentTimeMillis()-start));
        start = System.currentTimeMillis();
        System.out.println(quickFindNthUglyNumber(1500));
        System.out.println("cost : " + (System.currentTimeMillis()-start));
    }
}

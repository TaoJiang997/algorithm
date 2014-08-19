package tracy.algorithm.other;

/**
 * User: tracy
 * Date: 14-8-19
 * 输入一个正数n，输出所有和为n连续正数序列。
 * 例如输入15，由于1+2+3+4+5=4+5+6=7+8=15，所以输出3个连续序列1-5、4-6和7-8。
 */
public class FindContinuousSequence {

    public static void find(int n){
        if(n<3)
            return;
        int small = 1;
        int big = 2;
        int mid = (1+n)/2;
        int sum = small + big;
        while(small<mid){
            if(sum==n){
                print(small,big);
            }
            while(sum>n){
                sum-=small;
                small++;
                if(sum==n){
                    print(small,big);
                }
            }

            {
                big++;
                sum+=big;
            }
        }
    }


    private static void print(int start,int end){
        for(int i=start;i<=end;i++){
            System.out.print(i + ",");
        }
        System.out.println("");
    }


    public static void main(String[] args) {
        find(15);
    }
}

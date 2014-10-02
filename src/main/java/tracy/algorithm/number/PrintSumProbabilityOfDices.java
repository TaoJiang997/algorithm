package tracy.algorithm.number;

/**
 * User: tracy
 * Date: 14-9-29下午5:54
 */
public class PrintSumProbabilityOfDices {

    public static int max = 6;

    public static void solution1(int number){
        if(number<1)
            return;
        int maxSum = number * max;
        int[] probabilities = new int[maxSum-max+1];

        SumProbabilityOfDices(number,probabilities);

        double total = Math.pow(max,number);
        for(int i=number;i<=maxSum;++i){
            double ratio = probabilities[i-number]/total;
            System.out.println(i+" : "+ratio);
        }


    }

    private static void SumProbabilityOfDices(int number,int[] probabilities){
        for(int i =1;i<=max;++i)
            SumProbabilityOfDices(number, number, i, 0, probabilities);
    }

    private static void SumProbabilityOfDices(int original,int current,int value,int tmpSum,int[] probabilities){
        if(current==1){
            int sum = value + tmpSum;
            probabilities[sum-original]++;
        }else{
            for(int i=1;i<=max;++i){
                int sum = value + tmpSum;
                SumProbabilityOfDices(original,current-1,i,sum,probabilities);
            }
        }
    }

}

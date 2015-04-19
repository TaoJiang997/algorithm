package tracy.algorithm.array;

import java.util.Arrays;

/**
 * User: tracy
 * Time: 2015/4/19 18:00
 * LeetCode 16.3Sum Closest
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
    For example, given array S = {-1 2 1 -4}, and target = 1.
    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] num, int target) {
        if(num==null||num.length==0){
            return 0;
        }
        int length = num.length;
        int ret=0;
        if(length<=3){
            for(int i=0;i<length;i++){
                ret+=num[i];
            }
            return ret;
        }
        Arrays.sort(num);
        int res = num[0]+num[1]+num[2];
        for (int i=0; i<num.length-2; ++i) {
            if (i>0 && num[i]==num[i-1])  continue;
            int start = i+1, end = num.length-1;
            while (start<end) {
                int sum = num[i] + num[start] + num[end];
                if (Math.abs(sum-target) < Math.abs(res-target)) {
                    res = sum;
                }
                if (sum == target) {
                    return res;
                } else if (sum < target) {
                    start++;
                } else {
                    end--;
                }
            }//end-while
        }
        return res;
    }
}

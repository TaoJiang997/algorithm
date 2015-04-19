package tracy.algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * User: tracy
 * Time: 2015/4/19 17:44
 * LeetCode 15.3Sum
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * Note:
     Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
     The solution set must not contain duplicate triplets.
     For example, given array S = {-1 0 1 2 -1 -4},

     A solution set is:
     (-1, 0, 1)
     (-1, -1, 2)
 */
public class ThreeSum {
    List<List<Integer>> ret = new ArrayList<>();

    public List<List<Integer>> threeSum(int[] num){
        if(num==null || num.length<3)
            return ret;
        Arrays.sort(num);
        int length = num.length;
        for(int i=0;i<length-2;i++){
            if(i>0&&num[i]==num[i-1])
                continue;
            find(num,i+1,length-1,num[i]);
        }
        return ret;
    }

    public void find(int[] num,int begin,int end,int target){
        while(begin<end){
            if(num[begin]+num[end]+target==0){
                List<Integer> ans = new ArrayList<>();
                ans.add(target);
                ans.add(num[begin]);
                ans.add(num[end]);
                ret.add(ans);
                while(begin<end && num[begin]==num[begin+1])
                    begin++;
                while(begin<end && num[end]==num[end-1])
                    end--;
                begin++;
                end--;
            }else if(num[begin]+num[end]+target<0){
                while(begin<end && num[begin]==num[begin+1])
                    begin++;
                begin++;
            }else{
                while(begin<end && num[end]==num[end-1])
                    end--;
                end--;
            }
        }
    }

}

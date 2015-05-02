package tracy.algorithm.number;

import java.util.HashMap;
import java.util.Map;

/**
 * User: tracy
 * Time: 2015/5/1 19:00
 * LeetCode 128.Longest Consecutive Sequence
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
     For example,
     Given [100, 4, 200, 1, 3, 2],
     The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
    Your algorithm should run in O(n) complexity.
 */
public class LongestConsecutiveSequence {
    /*
        solution:
            利用map,先遍历放入map中：key为数组中的数值，val为1
            遍历数组：分别查找左右：如果存在，将map中左右的值置为0，并继续查找，直到左右都没有连续的
            此时，比较记录一下最大值。
     */
    public int longestConsecutive(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int val : nums)
            map.put(val,1);
        int max = 1;
        for(int key : nums){
            Integer val = map.get(key);
            if(val!=null && val>0){
                int upper = key+1;
                int length = 1;
                Integer upperVal = map.get(upper);
                while(upperVal!=null && upperVal>0){
                    map.put(upper,0);
                    upperVal = map.get(++upper);
                    length++;
                }
                int lower = key-1;
                Integer lowerVal = map.get(lower);
                while(lowerVal!=null && lowerVal>0){
                    map.put(lower,0);
                    lowerVal = map.get(--lower);
                    length++;
                }
                max = Math.max(max,length);
            }
        }
        return max;
    }
}

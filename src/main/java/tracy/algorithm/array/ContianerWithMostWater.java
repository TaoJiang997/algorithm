package tracy.algorithm.array;

/**
 * User: tracy
 * Time: 2015/4/18 22:47
 * LeetCode 11.Container With Most Water
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
   Note: You may not slant the container.
 */
public class ContianerWithMostWater {
    public int maxArea(int[] height) {
        if(height==null||height.length<2)
            return 0;
        int max=0;
        int low=0,high=height.length-1;
        while(low<high){
            if(height[low]>height[high]){
                max=Math.max(height[high]*(high-low),max);
                high--;
            }else{
                max=Math.max(height[low]*(high-low),max);
                low++;
            }
        }
        return max;
    }
}

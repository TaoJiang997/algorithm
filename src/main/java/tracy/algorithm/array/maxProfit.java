package tracy.algorithm.array;

/**
 * User: tracy
 * Time: 2015/4/6 21:20
 * LeetCode 122.Best Time to Buy and Sell Stock II
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times).
 * However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */
public class maxProfit {
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length<=1){
            return 0;
        }
        int min = prices[0], result = 0;
        for(int i=1,length=prices.length;i<length;i++){
            int val = prices[i]-min;
            if(val>0){
                result += val;
            }
            min = prices[i];
        }
        return result;
    }
}

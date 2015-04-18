package tracy.algorithm.string;

/**
 * User: tracy
 * Time: 2015/4/18 16:34
 * LeetCode 5.Longest Palindromic Substring(最长回文子串)
 * Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
 */
public class LongestPalindrome {
    public String find(String s) {
        if(s==null || "".equals(s)||s.length()==1)
            return s;
        int length = s.length();
        int max = 0;
        int start=0;
        //奇数
        for(int i=0;i<length;i++){
            int low=i-1,high=i+1;
            while(low>=0&&high<length&&s.charAt(low)==s.charAt(high)){
                int len = high-low+1;
                if(len>max){
                    max=len;
                    start=low;
                }
                low--;
                high++;
            }
        }

        //偶数
        for(int i=0;i<length;i++){
            int low=i,high=i+1;
            while(low>=0&&high<length&&s.charAt(low)==s.charAt(high)){
                int len = high-low+1;
                if(len>max){
                    max = len;
                    start=low;
                }
                low--;
                high++;
            }
        }
        return s.substring(start,start+max);
    }
}

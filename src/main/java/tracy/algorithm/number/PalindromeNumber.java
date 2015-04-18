package tracy.algorithm.number;

/**
 * User: tracy
 * Time: 2015/4/18 22:07
 * LeetCode 9.Palindrome Number
 * Determine whether an integer is a palindrome. Do this without extra space.
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if(x<0)
            return false;
        int div=1;
        while(x/div>=10)
            div*=10;
        while(x!=0){
            int left = x/div;
            int right = x%10;
            if(left!=right)
                return false;
            x=(x%div)/10;
            div/=100;
        }
        return true;
    }
}

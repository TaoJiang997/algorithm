package tracy.algorithm.string;

/**
 * User: tracy
 * Time: 2015/4/6 21:27
 * LeetCode 171.Excel Sheet Column Number(26进制~)
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 * For example:
     A -> 1
     B -> 2
     C -> 3
     ...
     Z -> 26
     AA -> 27
     AB -> 28
 */
public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        if(s==null)
            return 0;
        char[] ch = s.toCharArray();
        int base=1,sum=0;
        for(int i=ch.length-1;i>=0;i--){
            sum+=(ch[i]-'A'+1)*base;
            base*=26;
        }
        return sum;
    }
}

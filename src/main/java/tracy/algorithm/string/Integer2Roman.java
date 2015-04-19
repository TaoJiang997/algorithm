package tracy.algorithm.string;

/**
 * User: tracy
 * Time: 2015/4/19 15:50
 * LeetCode 12.Integer to Roman
 * Given an integer, convert it to a roman numeral.
   Input is guaranteed to be within the range from 1 to 3999.
     1.罗马数字共有7个，即I（1）、V（5）、X（10）、L（50）、C（100）、D（500）和M（1000）。罗马数字中没有“0”。
     2.重复次数：一个罗马数字最多重复3次。
     3.右加左减。
     4.左减的数字有限制，仅限于I、X、C，且放在大数的左边只能用一个。
     1~9: {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
     10~90: {"X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
     100~900: {"C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
     1000~3000: {"M", "MM", "MMM"}.
 */

public class Integer2Roman {
    public String intToRoman(int num){
        //罗马数字最大3999,所以最多四行
        String[][] roman = {
                {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
                {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
                {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
                {"", "M", "MM", "MMM"}
        };
        String ret = "";
        int digit = 0;
        while(num!=0){
            int remain = num%10;
            ret = roman[digit][remain]+ret;
            digit++;
            num/=10;
        }
        return ret;
    }

}

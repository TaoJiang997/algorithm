package tracy.algorithm.string;

/**
 * User: tracy
 * Time: 2015/4/19 15:54
 * LeetCode 13.Roman to String
 * Given a roman numeral, convert it to an integer.
   Input is guaranteed to be within the range from 1 to 3999.
   罗马数字规则见:{@link Integer2Roman}
 */
public class Roman2String {
    public int romanToInt(String s) {
        int ret = toNumber(s.charAt(0));
        for(int i=1,length = s.length();i<length;i++){
            if(toNumber(s.charAt(i-1))<toNumber(s.charAt(i))){
                //tracy(2015-4-19): s.charAt(i-1)已经加过了，所以需要多减一次
                ret +=toNumber(s.charAt(i))-2*toNumber(s.charAt(i-1));
            }else{
                ret+=toNumber(s.charAt(i));
            }
        }
        return ret;
    }


    int toNumber(char ch){
        switch (ch){
            case 'I':return 1;
            case 'V':return 5;
            case 'X':return 10;
            case 'L':return 50;
            case 'C':return 100;
            case 'D':return 500;
            case 'M':return 1000;
        }
        return 0;
    }

}

package tracy.algorithm.string;

/**
 * User: tracy
 * Time: 2015/4/18 17:59
 * LeetCode 8.String to Integer (atoi)
 * 1.null跟空字符串返回0
 * 2.如果是前面有空格则需要都滤掉
 * 3.正负号只能有一个或者没有
 * 4.数字开始后(去除了最开始的空格并且去掉了一开始可能的一个正负号)，如果有超过0~9的则返回当前值
 */
public class String2Int {
    public int myAtoi(String str) {
        if(str==null || "".equals(str))
            return 0;
        int length = str.length();
        int i=0;
        while(i<length&&str.charAt(i)==' ')
            i++;
        if(i<length){
            char startCh = str.charAt(i);
            int sign=1;
            if(startCh=='-'){
                sign=-1;
                i++;
            }else if(startCh=='+'){
                i++;
            }
            long ans=0;
            while(i<length&&str.charAt(i)>='0'&&str.charAt(i)<='9'){
                ans=ans*10+(str.charAt(i)-'0');
                if(ans>Integer.MAX_VALUE)
                    return sign>0 ? Integer.MAX_VALUE:Integer.MIN_VALUE;
                i++;
            }
            ans*=sign;
            return (int)ans;
        }else
            return 0;
    }

}

package tracy.algorithm.number;

import java.math.BigInteger;

/**
 * Created with IntelliJ IDEA.
 * User: tracy
 * Date: 14-7-29
 * Time: 下午11:44
 * To change this template use File | Settings | File Templates.
 */
public class BigNumber {
    public static String add(String f,String s){
        char[] a = new StringBuffer(f).reverse().toString().toCharArray();
        char[] b = new StringBuffer(s).reverse().toString().toCharArray();
        int lenA = a.length;
        int lenB = b.length;
        int len = lenA>lenB?lenA:lenB;
        int[] result = new int[len+1];
        int add = 0;
        int sum;
        for(int i=0;i<len;i++){
            int aint = i<lenA ? (a[i]-'0'):0;
            int bint = i<lenB ? (b[i]-'0'):0;
            sum = aint + bint + add;
            result[i]=sum%10;
            add=sum/10;
        }
        result[len] = add;//最后进位
        StringBuilder sb = new StringBuilder();
        boolean flag = true;//前面是否有0
        for(int i=len;i>=0;i--){
            if(result[i]==0 && flag)
                continue;
            else
                flag = false;
            sb.append(result[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "00010292385734875378458737589283587348571491332045943500";
        String f = "00000291847293592875928746435460000";
        System.out.println(add(s,f));
        BigInteger a = new BigInteger(s);
        BigInteger b = new BigInteger(f);
        System.out.println(a.add(b));
    }
}

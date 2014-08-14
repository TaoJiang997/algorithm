package tracy.algorithm.string;

/**
 * Created with IntelliJ IDEA.
 * User: tracy
 * Date: 14-5-24
 * Time: 下午5:26
 * To change this template use File | Settings | File Templates.
 */
public class KMP {


    private int[] computePrefix(String pattern) {
        int length = pattern.length();
        int[] prefix = new int[length];

        prefix[0] = 0;

        int k = 0;
        for(int i = 1; i < length; i++) {
            while(k > 0 && pattern.charAt(k) != pattern.charAt(i)) {
                k = prefix[k -1];
            }
            if(pattern.charAt(k) == pattern.charAt(i))
                k++;
            prefix[i] = k;
        }

        return prefix;
    }


























    private int[] preProcessPattern(String pattern){
        int len = pattern.length();
        int jump[] = new int[len];
        jump[0] = 0;
        int k = 0;
        for(int i=1;i<len;i++){
            while (k>0 && pattern.charAt(k)!=pattern.charAt(i)){
                k = jump[k-1];
            }
            if(pattern.charAt(k) == pattern.charAt(i))
                k++;
            jump[i] = k;
        }
        return jump;
    }







}

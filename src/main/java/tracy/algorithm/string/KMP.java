package tracy.algorithm.string;

/**
 * Created with IntelliJ IDEA.
 * User: tracy
 * Date: 14-5-24
 * Time: 下午5:26
 * To change this template use File | Settings | File Templates.
 */
public class KMP {

    public static int search(String source,String pattern){
        if(source == null || pattern==null || source.equals("") || pattern.equals("") || source.length()<pattern.length()){
            return -1;
        }
        int[] next = next(pattern);
        int i = 0,j=0;
        int slen = source.length();
        int plen = pattern.length();

        while(i<slen&&j<plen){
            if(j==-1||source.charAt(i)==pattern.charAt(j)){
                i++;
                j++;
            }else{
                j=next[j];
            }
        }
        if(j==plen){
            return i-j;
        }else
            return -1;
    }


    private static int[] next(String pattern) {
        int length = pattern.length();
        int[] next = new int[length];

        next[0] = -1;
        int k = -1;

        int j = 0;
        while(j<length-1){
            if(k == -1 || pattern.charAt(k) == pattern.charAt(j)) {//
                ++k;
                ++j;
                next[j]=k;
            }else{
                k=next[k];//解释见下面
            }
        }

        return next;
    }


    /*
    (A B C) D (A B C) E
    当D与E不相等时，需要找ABC中的前后缀相同长度n，这样才能保证E前面
    的n个字符与最前面的n个字符相同，才可以比较n+1个字符与E。

    前面推导见July blog http://blog.csdn.net/v_july_v/article/details/7041827
    */

    public static void main(String[] args) {
        System.out.println(search("abacababc","ababc"));
    }

}

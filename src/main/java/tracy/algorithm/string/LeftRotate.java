package tracy.algorithm.string;

/**
 * Created with IntelliJ IDEA.
 * User: tracy
 * Date: 14-8-17
 * Time: 下午3:16
 * To change this template use File | Settings | File Templates.
 */
public class LeftRotate {

    public static String rotate(String str,int pos){
        if(str==null || str.isEmpty() || pos<0 || pos>=str.length()){
            return null;
        }

        str = reverse(str,0,pos-1);
        str = reverse(str,pos,str.length()-1);
        str = reverse(str,0,str.length()-1);
        return str;
    }

    private static String reverse(String str,int start,int end){
        char[] chars = str.toCharArray();
        while(start<=end){
            char tmp = chars[start];
            chars[start]=chars[end];
            chars[end]=tmp;
            start++;
            end--;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(rotate("abcdefg",4));
    }
}

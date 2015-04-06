package tracy.algorithm.string;

/**
 * User: tracy
 * Date: 14-8-17
 * Time: 下午3:16
 * 给定一个字符串，要求把字符串前面的若干个字符移动到字符串的尾部，
 * 如把字符串“abcdef”前面的2个字符'a'和'b'移动到字符串的尾部，使得原字符串变成字符串“cdefab”。
 * 请写一个函数完成此功能，要求对长度为n的字符串操作的时间复杂度为 O(n)，空间复杂度为 O(1)。
 */
public class RotateString {

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

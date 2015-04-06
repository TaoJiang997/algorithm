package tracy.algorithm.string;

/**
 * User: tracy
 * Time: 2015/4/6 22:11
 * LeetCode 151.Reverse Words in a String
 * Given an input string, reverse the string word by word.
     For example,
     Given s = "the sky is blue",
     return "blue is sky the".
 */
public class ReverseWordsInAString {
    public String reverseWords(String s) {
        if(s==null)
            return null;
        if(s.trim().equals(""))
            return "";
        String[] tmp = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i=tmp.length-1;i>=0;i--){
            if(tmp[i].trim().equals(""))continue;
            sb.append(tmp[i]);
            if(i!=0){
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}

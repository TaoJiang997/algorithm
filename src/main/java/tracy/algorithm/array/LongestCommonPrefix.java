package tracy.algorithm.array;

/**
 * User: tracy
 * Time: 2015/4/19 16:32
 * LeetCode 14.Longest Common Prefix
 * Write a function to find the longest common prefix string amongst an array of strings.
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs==null||strs.length==0)
            return "";
        if(strs.length==1)
            return strs[0];
        String first = strs[0];
        if(first==null || first.length()==0)
            return "";
        int i=0,length=first.length();
        StringBuilder sb = new StringBuilder();
        //tracy(2015-4-19): 最长不会超过任意字符串的长度，所以以第一个字符串的长度为循环条件
        while(i<length){
            char ch = first.charAt(i);
            for(int j=1,len=strs.length;j<len;j++){
                String str = strs[j];
                if(str==null || str.length()<=i)
                    return sb.toString();
                if(ch!=str.charAt(i))
                    return sb.toString();
            }
            sb.append(ch);
            i++;
        }
        return sb.toString();
    }
}

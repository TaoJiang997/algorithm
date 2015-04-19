package tracy.algorithm.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * User: tracy
 * Time: 2015/4/19 20:36
 */
public class LetterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if(digits==null||digits.length()==0)
            return list;
        int i=0,length = digits.length();
        String str = get(digits.charAt(i));
        //remove first empty str
        while(str.length()==0){
            i++;
            if(i<length)
                str=get(digits.charAt(i));
            else
                break;
        }
        if(str.length()==0||i>=length)
            return list;
        char[] tiny = str.toCharArray();
        List<String> sub = letterCombinations(digits.substring(i+1));
        for(char cha : tiny){
            if(sub.isEmpty()){
                StringBuilder sb = new StringBuilder();
                sb.append(cha);
                list.add(sb.toString());
            }else{
                for(String st : sub){
                    StringBuilder sb = new StringBuilder();
                    sb.append(cha);
                    sb.append(st);
                    list.add(sb.toString());
                }
            }

        }
        return list;
    }

    private String get(char digit){
        switch(digit){
            case '2':
                return "abc";
            case '3':
                return "def";
            case '4':
                return "ghi";
            case '5':
                return "jkl";
            case '6':
                return "mno";
            case '7':
                return "pqrs";
            case '8':
                return "tuv";
            case '9':
                return "wxyz";
            case '0':
                return " ";
            default:
                return "";
        }
    }

    public static void main(String[] args) {
        List<String> list = new LetterCombinationsOfAPhoneNumber().letterCombinations("22");
        for(String str : list){
            System.out.printf(str+" ");
        }
    }
}

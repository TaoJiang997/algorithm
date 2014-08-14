package tracy.algorithm.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: tracy
 * Date: 14-8-13
 * Time: 下午11:58
 * To change this template use File | Settings | File Templates.
 */
public class LCS {
    public static void find(String str1,String str2){
        if(str1==null || str2==null || str1.equals("") || str2.equals("")){
            return;
        }
        int[][] matrix = new int[str1.length()+1][str2.length()+1];
        for(int i=str1.length()-1;i>=0;i--){
            for(int j=str2.length()-1;j>=0;j--){
                if(str1.charAt(i)==str2.charAt(j)){
                    matrix[i][j]=matrix[i+1][j+1]+1;
                }else{
                    matrix[i][j]=Math.max(matrix[i+1][j],matrix[i][j+1]);
                }
            }
        }

        int i=0,j=0;
        while(i<str1.length() && j<str2.length()){
            if(str1.charAt(i)==str2.charAt(j)){
                System.out.print(str1.charAt(i));
                i++;
                j++;
            }else if(matrix[i+1][j]>=matrix[i][j+1]){
                i++;
            }else {
                j++;
            }
        }
    }

    public static void find2(String str1,String str2){
        if(str1==null || str2==null || str1.equals("") || str2.equals("")){
            return;
        }
        int[][] matrix = new int[str1.length()+1][str2.length()+1];
        for(int i=0;i<str1.length();i++){
            for(int j=0;j<str2.length();j++){
                if(str1.charAt(i)==str2.charAt(j)){
                    matrix[i+1][j+1]=matrix[i][j]+1;
                }else{
                    matrix[i+1][j+1]=Math.max(matrix[i+1][j],matrix[i][j+1]);
                }
            }
        }

        for(int i=0;i<str1.length()+1;i++){
            for(int j=0;j<str2.length()+1;j++){
                System.out.print(matrix[i][j]+" ");
                if(j==str2.length()){
                    System.out.println("");
                }
            }
        }
        int i=str1.length()-1,j=str2.length()-1;
        List<Character> list = new ArrayList<Character>();
        while(i>=0 && j>=0){
            if(str1.charAt(i)==str2.charAt(j)){
                list.add(str1.charAt(i));
                i--;
                j--;
            }else if(matrix[i+1][j]>=matrix[i][j+1]){
                j--;
            }else {
                i--;
            }
        }
        for(int m=list.size()-1;m>=0;m--){
            System.out.print(list.get(m));
        }
    }


    public static void main(String[] args) {
//        find("akqrshrengxqiyxuloqk", "tdzbujtlqhecaqgwfzbc");
//        System.out.println("");
//        find2("akqrshrengxqiyxuloqk", "tdzbujtlqhecaqgwfzbc");
//        System.out.println("");
        find("BDCABA","ABCBDAB");
        System.out.println("");
        find2("BDCABA", "ABCBDAB");
    }
}

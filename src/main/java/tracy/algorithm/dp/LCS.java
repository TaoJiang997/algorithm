package tracy.algorithm.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * User: tracy
 * Date: 14-8-13
 * Time: 下午11:58
 * 子串定义：如果字符串一的所有字符按其在字符串中的顺序出现在另外一个字符串二中，则字符串一称之为字符串二的子串。
 * 注意，并不要求子串（字符串一）的字符必须连续出现在字符串二中。
     LCS：请编写一个函数，输入两个字符串，求它们的最长公共子串，并打印出最长公共子串。
     例如：输入两个字符串BDCABA和ABCBDAB，字符串BCBA和BDAB都是是它们的最长公共子序列，则输出它们的长度4，并打印任意一个子序列。
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

    /*
        solution:
            如果str1(i+1)与str2(j+1)相同，则len(i+1,j+1)==len(i,j)+1;
            否则len(i+1,j+1)==Max(len(i+1,j),len(i,j+1));
            len(m+1,n+1)为最大值
     */
    public static void find2(String str1,String str2){
        if(str1==null || str2==null || str1.equals("") || str2.equals("")){
            return;
        }
        //第一行与第一列为初始值，方便处理与理解
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

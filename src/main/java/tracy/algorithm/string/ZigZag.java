package tracy.algorithm.string;

/**
 * User: tracy
 * Time: 2015/4/18 17:41
 * LeetCode 6.ZigZag Conversion
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
     P   A   H   N
     A P L S I I G
     Y   I   R
     And then read line by line: "PAHNAPLSIIGYIR"
     Write the code that will take a string and make this conversion given a number of rows:

     string convert(string text, int nRows);
     convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".

    思路：
    1       9           17
    2     8 10       16 18
    3   7   11    15    19
    4 6     12 14       20
    5       13          21
    1到8为一个zig,9到16为一个zig,以此类推，每个zig大小为zigSize=2*nRows-2(多余的两个为对角重复的两个)
    第一行跟最后一行每个元素差距为zigSize;
    其余行还有个中间量位置为middle=base+zigSize-2(i-1)
    base:8的base为2;15的base为11
    i为1到nRows
 */
public class ZigZag {
    public String convert(String s, int nRows) {
        if(nRows==1)
            return s;
        StringBuilder sb = new StringBuilder();
        int length = s.length();
        int zigSize=2*nRows-2;
        for(int i=1;i<=nRows;i++){
            for(int base=i-1;;base+=zigSize){
                if(base>=length)
                    break;
                sb.append(s.charAt(base));
                if(i>1&&i<nRows){
                    int middle = base+zigSize-2*(i-1);
                    if(middle<length)
                        sb.append(s.charAt(middle));
                }
            }
        }
        return sb.toString();
    }
}

package tracy.algorithm.number;

/**
 * User: tracy
 * Date: 14-9-24上午12:04
 * 打印1到最大的n位数
 */
public class PrintOne2Nmax {

    // Print numbers from 1 to the maximum number with n digits, in order
    public static void print(int n){
        // 0 or minus numbers are invalid input
        if(n<=0)
            return;
        char[] number = new char[n+1];
        number[n]='\0';
        for(int i=0;i<10;++i){
            // first digit can be 0 to 9
            number[0] = (char)(i +'0');
            printRecursively(number,n,0);
        }
    }

    // length: length of number
    // index: current index of digit in number for this round
    private static void printRecursively(char[] number,int len,int index){
        // we have reached the end of number, print it
        if(index == len -1){
            printArray(number);
            return;
        }
        for(int i=0;i<10;++i){
            // next digit can be 0 to 9
            number[index+1] =  (char)(i +'0');
            // go to the next digit
            printRecursively(number, len, index+1);
        }

    }

    private static void printArray(char[] number){
        boolean isBeginning0 = true;
        int nLength = number.length;

        for(int i = 0; i < nLength; ++ i)
        {
            if(isBeginning0 && number[i] != '0')
                isBeginning0 = false;

            if(!isBeginning0)
            {
                System.out.print(number[i]);
            }
        }

        System.out.println("");
    }

    public static void main(String[] args) {
        print(3);
    }
}

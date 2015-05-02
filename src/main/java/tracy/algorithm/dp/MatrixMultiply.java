package tracy.algorithm.dp;

/**
 * User: tracy
 * Date: 14-7-15
 * Time: 上午6:43
 * 给定n个矩阵｛A1,A2,…,An｝，其中Ai与Ai+1是可乘的，i=1，2…，n-1。考察该n个矩阵的连乘积：A1*A2*A3……*An
 * 如何确定计算矩阵连乘积的计算次序，使得依此次序计算矩阵连乘积需要的数乘次数最少
 */
public class MatrixMultiply {

    /**
     *
     * @param n 矩阵长度
     * @param p 长度为n+1,矩阵维数数组，｛A1,A2,…,An｝ 中 Ai的维数为P[i-1]*P[i]
     */
    public void multiple(int n,int[] p){
        int[][] m = new int[n][n];//存放i,j最小值
        int[][] s = new int[n][n];//i,j在k位置二分m[i][j]最小，即Ai*Ai+1...Ak,Ak+1*Ak+2...Aj这种二分时，m[i][j]最小

        /*
            等式m[i][j]=m[i][k]+m[k+1][j]+p[i-1]*p[k]*p[j]中m[i][j]的计算依赖m[i][k]与m[k+1][j]的值，所以按照下面方式循环
         */
        /*
            1.先计算相邻两个相乘的次数：A1*A2,A2*A3,A3*A4...An-1*An的值，存入二维数组m中
            2.计算相距两个的最小值A1*A2*A3,A2*A3*A4,...An-2*An-1*An的最小值：
              A1*A2*A3需要A1*A2,A2*A3的结果，所以先进行第一步的计算
            3.依次类推计算相距三个，四个，...个的结果
            4.最终计算到差值为n-1即A1,A2*A3...An与A1*A2...An-1,An即可
            5.二维数组s用于存放Ai...Aj从哪个位置分开最小：例如A1A2A3A4可能是A1,A2A3A4或者是A1A2,A3A4或者是A1A2A3,A4
              如果是A1A2,A3A4则s[1][4]=2
         */
        //r表示i,j之间的差值:1到n-1,上面的第一步r=1,然后r=2,3...n-1
        for(int r=1;r<n;r++){
            //i与j差为r时，一共有n-r-1种情况：例如r=1有A1*A2,A2*A3,A3*A4...An-1*An共n-r-1=n-2中情况
            //i,j为下标,又因为最小的分组是1个,与n-1个所以i与j最大为n-2所以n维数组即可
            for(int i=1;i<n-r;i++){
                int j = i+r;
                //初始化把Ai,Ai+1,....Aj 分为Ai与Ai+1,...Aj
                m[i][j]=m[i+1][j]+p[i-1]*p[i]*p[j];
                s[i][j]=i;
                //依次分为: Ai*Ai+1与Ai+2*Ai+3...*Aj; Ai*Ai+1*Ai+2与Ai+3*Ai+4...*Aj ; ... ; Ai*Ai+1...*Aj-1与Aj
                for(int k=i+1;k<j;k++){
                    int t = m[i][k]+m[k+1][j]+p[i-1]*p[k]*p[j];
                    if(t<m[i][j]){
                        m[i][j]=t;
                        s[i][j]=k;
                    }
                }
            }
        }
        /*
            m[1][n]为最小的结果
            拆分方法存在s[][]中：
            s[1][n]=k;则应该是A1...Ak,Ak+1...An
            然后再根据s[1][k]跟s[k+1][n]查找子问题的拆分方法
         */
    }










}

package tracy.algorithm.dp;

/**
 * Created with IntelliJ IDEA.
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
     * @param p 矩阵维数数组，Ai的维数为P[i-1]*P[i]
     */
    public void multiple(int n,int[] p){
        int[][] m = new int[n][n];//存放i,j最小值
        int[][] s = new int[n][n];//i,j在k位置二分m[i][j]最小值

        //等式m[i][j]=m[i][k]+m[k+1][j]+p[i-1]*p[k]*p[j]中m[i][j]的计算依赖
        //m[i][k]与m[k+1][j]的值，所以按照下面方式循环
        for(int r=1;r<n;r++){//r表示i,j之间的差值(i=j时m[i][j]=0,最小为1，最大为n-1)
            for(int i=1;i<n-r;i++){
                int j = i+r;
                m[i][j]=m[i+1][j]+p[i-1]*p[i]*p[j];
                s[i][j]=i;
                for(int k=i+1;k<j;k++){
                    int t = m[i][k]+m[k+1][j]+p[i-1]*p[k]*p[j];
                    if(t<m[i][j]){
                        m[i][j]=t;
                        s[i][j]=k;
                    }
                }
            }
        }
    }










}

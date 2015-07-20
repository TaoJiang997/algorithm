package tracy.algorithm.test;



/**
 * User: tracy
 * Date: 14-7-20
 */
public class Tracy {
    public static void main(String[] args) {
        int[] src = new int[]{1,2,3,4,5};
        int[] dest = new int[src.length-1];
        System.arraycopy(src,3,dest,0,2);
        System.arraycopy(src,0,dest,2,2);
        for (int val : dest)
            System.out.print(val);
    }
}

package topcoder.DivII500;

/**
 * @author ksharma
 */
public class NumberofFiboCalls {

    public int[] fiboCallsMade(int n) {
        int[] dp0 = new int[41];
        int[] dp1 = new int[41];
        dp0[0] = 1;
        dp1[1] = 1;
        for (int i = 2; i <= 40; i++) {
            dp0[i] = dp0[i - 1] + dp0[i - 2];
            dp1[i] = dp1[i - 1] + dp1[i - 2];
        }
        return new int[]{dp0[n], dp1[n]};
    }

    public static void main(String[] args) {
        NumberofFiboCalls nf=new NumberofFiboCalls();
        System.out.println(nf.fiboCallsMade(40));
    }
}

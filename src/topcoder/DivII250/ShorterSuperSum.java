package topcoder.DivII250;

/**
 * @author ksharma
 */
public class ShorterSuperSum {
    public int calculate(int k, int n){
        int [][]dp=new int[k+1][n+1];
        for(int i=0;i<=k;i++){
            dp[i][0]=0;
        }
        for(int j=0;j<=n;j++){
            dp[0][j]=j;
        }
        for(int i=1;i<=k;i++){
            for(int j=1;j<=n;j++){
                dp[i][j]=dp[i][j-1] + dp[i-1][j];
            }
        }
        return dp[k][n];
    }

    public static void main(String[] args) {
        ShorterSuperSum ss=new ShorterSuperSum();
        System.out.println(ss.calculate(1,3));
    }
}

import java.util.Arrays;

/**
 * @author ksharma
 */

//https://leetcode.com/problems/perfect-squares/description/
public class PerfectSquare {
    public int numSquares(int n) {
        if(n==0 || n==1)return 1;
        int []dp=new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            if(isSquare(i)){
                dp[i]=1;
            }else{
                for(int j=1;j<i;j++){
                    dp[i]=Math.min(dp[i],dp[j]+dp[i-j]);
                }
            }
        }
        return dp[n];
    }

    public boolean isSquare(double n){
        double a=Math.sqrt(n);
        return (a-Math.floor(a))==0;
    }

    public static void main(String []args){
        PerfectSquare ps=new PerfectSquare();
        ps.numSquares(4);
    }
}

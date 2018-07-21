/**
 * @author ksharma
 */
public class Knapsack01 {

    public int getMaxVal(int[]v,int[]w,int k){
        int n=v.length;
        int [][]dp=new int[n+1][k+1];
        initializeDP(dp);
        for(int i=0;i<=n;i++){
            dp[i][0]=0;
        }
        for(int j=0;j<=k;j++){
            dp[0][j]=0;
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=k;j++){
                if(j>=w[i-1]){
                    dp[i][j]=Math.max(dp[i][j],dp[i-1][j-w[i-1]]+v[i-1]);
                }
                dp[i][j]=Math.max(dp[i][j],dp[i-1][j]);
            }
        }
        return dp[n][k];
    }

    private void initializeDP(int[][] dp) {
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=-1;
            }
        }
    }

    public static void main(String[]args){
        Knapsack01 kp=new Knapsack01();
        int value[]=new int[]{60,100,120};
        int weight[]=new int[]{10,20,30};
        int k=50;
        System.out.println(kp.getMaxVal(value,weight,k));
    }
}

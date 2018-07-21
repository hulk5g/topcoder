package DP;

/**
 * @author ksharma
 */
public class ClimibingStairs {

    public int minCostClimbingStairs(int[] cost) {
       // return helperRecursion(cost,cost.length);
        return helperDP(cost,cost.length);
    }

    //using -recursion
    private int helperRecursion(int[] cost, int n) {
        if(n==0)return 0;
        if(n==1)return 0;
        if(n==2)return Math.min(cost[0],cost[1]);
        return Math.min(cost[n-1]+ helperRecursion(cost,n-1),cost[n-2]+ helperRecursion(cost,n-2));
    }

    private int helperDP(int []cost,int n){
        int [] dp=new int[n+1];
        dp[0]=0;
        dp[1]=0;
        dp[2]=Math.min(cost[0],cost[1]);
        for(int i=3;i<=n;i++){
            dp[i]=Math.min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2]);
        }
        return dp[n];
    }

    public static void main(String []args){
      int[]cost= {10,15,20};
      ClimibingStairs cs=new ClimibingStairs();
        System.out.println(cs.minCostClimbingStairs(cost));
    }
}

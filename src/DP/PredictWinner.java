package DP;

/**
 * @author ksharma
 */
public class PredictWinner {
    public boolean PredictTheWinner(int[] nums) {
        if(nums.length==0)return false;
        int totalSum=0;
        int [][]dp=new int[nums.length][nums.length];
        for(int i=0;i<nums.length;i++){
            totalSum+=nums[i];
        }
        for(int k=1;k<=nums.length;k++){
            for(int i=0;i<nums.length-k+1;i++){
                int j=i+k-1;
                if(i==j)dp[i][j]=nums[i];
                else if(j==i+1)dp[i][j]=Math.max(nums[i],nums[j]);
                else{
                    int x=dp[i+2][j];
                    int y=dp[i+1][j-1];
                    int z=dp[i][j-2];
                    int temp1=nums[i]+Math.min(x,y);
                    int temp2=nums[j]+Math.min(y,z);
                    dp[i][j]=Math.max(temp1,temp2);
                }
            }
        }
        int player1=dp[0][nums.length-1];
        int player2=totalSum-player1;
        if(player1>=player2)return true;
        return false;

    }

    public static void main(String []args){
        PredictWinner pw=new PredictWinner();
        int [] input={1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        System.out.println(pw.PredictTheWinner(input));
    }
}

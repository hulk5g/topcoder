package DP;

/**
 * @author ksharma
 */
public class CombinationSumIV {
    int count=0;
    public int combinationSum4(int[] nums, int target) {
       // helper(nums,target,0,0);
        return dpHelper(nums,target);
    }

    private int dpHelper(int []nums, int target){
        int []dp=new int[target+1];
        dp[0]=1;
        for(int j=1;j<=target;j++){
            for(int i=0;i<nums.length;i++){
                if(nums[i]<=j){
                    dp[j]+=dp[j-nums[i]];
                }
            }
        }
        return dp[target];
    }


    //using recursion
    private void helper(int[] nums, int target, int idx, int tempSum) {
        if(tempSum==target){
            count++;
        }else if(tempSum>target)return;
        for(int i=0;i<nums.length;i++){
            helper(nums,target,i+1,tempSum+nums[i]);
        }
    }

    public static void main(String []args){
        CombinationSumIV cs=new CombinationSumIV();
        int [] nums = {1, 2, 3};
        int target = 4;
        System.out.println(cs.combinationSum4(nums,target));
    }
}

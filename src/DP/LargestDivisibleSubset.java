package DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ksharma
 */
public class LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer>result=new ArrayList<>();
        int n=nums.length;
        if(n==0)return result;
        int []dp=new int[n];
        Arrays.sort(nums);
        Arrays.fill(dp,1);
        int maxIndex=0;
        int max=1;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]%nums[j]==0){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                    if(dp[i]>max){
                        max=dp[i];
                        maxIndex=i;
                    }
                }
            }
        }

        int temp = nums[maxIndex];
        for(int i=maxIndex;i>=0;i--){
            if((temp%nums[i]==0 || nums[i]%temp==0) && dp[i]==max){
                result.add(nums[i]);
                temp=nums[i];
                max--;
            }
        }
        return result;
    }

    public static void main(String []args){
        LargestDivisibleSubset ld=new LargestDivisibleSubset();
        System.out.println(ld.largestDivisibleSubset(new int[]{1,2,4,8}));
    }
}

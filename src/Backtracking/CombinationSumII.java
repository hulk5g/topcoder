package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ksharma
 */
public class CombinationSumII {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>>result=new ArrayList<>();
        Arrays.sort(candidates);
        helper(result,target,new ArrayList<Integer>(),0,0,candidates);
        return result;
    }

    private void helper(List<List<Integer>> result, int target, ArrayList<Integer> temp,int idx, int k, int[] nums) {
        if(k==target){
            result.add(new ArrayList<>(temp));
            return;
        }
        for(int i=idx;i< nums.length;i++){
            if(k+nums[i]<=target){
                k+=nums[i];
                temp.add(nums[i]);
                helper(result,target,temp,i,k,nums);
                k-=nums[i];
                temp.remove(temp.size()-1);
            }
        }

    }

    public static void main(String []args){
        int[] candidates=new int[]{8,7,4,3};
        CombinationSumII cs=new CombinationSumII();
        System.out.println(cs.combinationSum(candidates,11));
    }
}

package Backtracking;

import java.util.*;

/**
 * @author ksharma
 */
public class DuplicateSubsets {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>>result=new HashSet<>();
        List<List<Integer>> result1=new ArrayList<>();
        Arrays.sort(nums);
        helper(result,new ArrayList<Integer>(),0,nums);
        result1.addAll(result);
        return result1;
    }

    private void helper(Set<List<Integer>> result, ArrayList<Integer> temp, int idx, int[] nums) {
        if(idx> nums.length){
            return;
        }
        result.add(new ArrayList<>(temp));
        for(int i=idx;i<nums.length;i++){
            temp.add(nums[i]);
            helper(result,temp,i+1,nums);
            temp.remove(temp.size()-1);
        }
    }

    public static void main(String []args){
        int[]num={1,2,2};
        DuplicateSubsets ds=new DuplicateSubsets();
        System.out.println(ds.subsetsWithDup(num));
    }
}

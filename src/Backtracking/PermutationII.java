package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ksharma
 */
public class PermutationII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        try {
            List<List<Integer>> result = new ArrayList<>();
            Arrays.sort(nums);
            boolean[] visited = new boolean[nums.length];
            helper(result, new ArrayList<Integer>(), 0, nums, visited);
            return result;
        }finally {
            System.out.println("finally");
        }
    }

    private void helper(List<List<Integer>> result, ArrayList<Integer> temp, int idx, int[] nums,boolean[]visited) {
        if(idx==nums.length){
            List<Integer>temp1=Arrays.stream(nums).boxed().collect(Collectors.toList());
            result.add(temp1);
            return;
        }
        for(int i=idx;i<nums.length;i++){
            if(!visited[i]) {
                swap(i, idx, nums);
                visited[i]=true;
                helper(result, temp, i + 1, nums, visited);
                visited[i]=false;
                swap(i, idx, nums);
            }
        }
    }

    private void swap(int i, int idx, int[] nums) {
        int temp=nums[i];
        nums[i]=nums[idx];
        nums[idx]=temp;
    }

    public static void main(String []args ){
        PermutationII p=new PermutationII();
        int[]nums={3,2,4,1};
        System.out.println(p.permuteUnique(nums));
    }
}

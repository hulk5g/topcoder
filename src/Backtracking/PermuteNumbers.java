package Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ksharma
 */
public class PermuteNumbers {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        helper(result,nums,0);
        return result;
    }

    private static void helper(List<List<Integer>> result, int[] nums, int index) {
        if(index==nums.length){

        }
    }

    public static void main(String []args){
        int []num={1,2,3};
        System.out.println(PermuteNumbers.permute(num));
    }
}

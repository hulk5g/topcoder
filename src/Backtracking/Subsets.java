package Backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author ksharma
 */
public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        helper2(result,new ArrayList<Integer>(),0,nums);
        return result;
    }

    private void helper2(List<List<Integer>> result, ArrayList<Integer> temp, int idx, int[] nums){
        if(result.size()==Math.pow(2,nums.length)){
            return;
        }else{
            result.add(new ArrayList<>(temp));
        }
        for(int i=idx;i<nums.length;i++){
            temp.add(nums[i]);
            helper2(result,temp,i+1,nums);
            temp.remove(temp.size()-1);
        }
    }

  /*  private void helper(List<List<Integer>> result, ArrayList<Integer> temp, int idx, int size, int[] nums,
            boolean[]visited) {
        if(result.size()==Math.pow(2,nums.length)){
            return;
        }
        for(int i=idx;i<nums.length;i++){
            if(temp.size()<size && !visited[i]){
                temp.add(nums[i]);
                visited[i]=true;
                helper(result,temp,idx+1,size,nums,visited);
                temp.remove(temp.size()-1);
                visited[i]=false;
            }

        }
        if(temp.size()==size){
            result.add(new ArrayList<>(temp));
            helper(result,temp,idx,size+1,nums,visited);
        }

    }
*/
    public static void main(String []args){
        int []num={1,2,3,4};
        Subsets s=new Subsets();
        List<List<Integer>>result=s.subsets(num);
        Collections.sort(result,(a,b)->a.size()-b.size());
        System.out.println(result);

    }
}

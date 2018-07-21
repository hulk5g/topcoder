package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Divide the array into k subsets with equals sum
 * @author ksharma
 */

public class KPartitions {

    public List<List<Integer>> getPartitions(List<Integer> nums,int k){
        List<List<Integer>>result=new ArrayList<>();
        int sum= nums.stream().mapToInt(Integer::intValue).sum();
        if(sum%k!=0)return result;
        boolean[]visited=new boolean[nums.size()];
        helper(result,nums,0,visited,new ArrayList<>(),k,k,sum/k,0);
        return result;
    }

    public void helper(List<List<Integer>> result, List<Integer>nums,int idx,boolean []visited,List<Integer>temp,int
            k,int origK,int targetSum,int currSum){
        if(k==0 || result.size()==origK){
            return;
        }else if(currSum==targetSum){
            result.add(new ArrayList<>(temp));
            helper(result,nums,0,visited,new ArrayList<>(),k-1,origK,targetSum,0);
            return;
        }

        for(int i=idx;i<nums.size();i++){
            if(currSum+nums.get(i)<=targetSum && visited[i]==false){
                visited[i]=true;
                temp.add(nums.get(i));
                helper(result,nums,i+1,visited,temp,k,origK,targetSum,currSum+nums.get(i));
                visited[i]=false;
                temp.remove(temp.size()-1);
            }
        }
    }

    public static void main(String []args){
        KPartitions kp=new KPartitions();
        Integer [] arr={4, 3, 2, 3, 5, 2, 1};
        System.out.println(kp.getPartitions(Arrays.asList(arr),4));
    }
}

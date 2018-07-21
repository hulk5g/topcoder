package Backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author ksharma
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum3(int k, int n) {
        return solution2(k,n);
    }

    public List<List<Integer>> solution2(int k, int n) {
        List<List<Integer>>result=new ArrayList<>();
        helper2(k,n,1,new ArrayList<Integer>(),result);
        return result;
    }

    private void helper2(int k, int n, int idx, ArrayList<Integer> temp, List<List<Integer>>result) {
        if(temp.size()==k){
           int sum= temp.stream().reduce((x,y)->x+y).get();
           if(sum==n){
               result.add(new ArrayList<>(temp));
           }
           return;
        }else if(temp.size()>k)return;
        for(int i=idx;i<10;i++){
            temp.add(i);
            helper2(k,n,i+1,temp,result);
            temp.remove(temp.size()-1);
        }
    }

    public List<List<Integer>> solution1(int k, int n) {
        List<List<Integer>>result=new ArrayList<>();
        boolean []visited=new boolean[10];
        Set<List<Integer>> set=new HashSet<>();
        helper(set,k,n,visited);
        result.addAll(set);
        return result;
    }

    public void helper(Set<List<Integer>>result,int k,int n, boolean []visited){
        if(k==0 && n==0){
            List<Integer>r=new ArrayList<>();
            for(int i=1;i<visited.length;i++){
                if(visited[i]){
                    r.add(i);
                }
            }
            result.add(r);
            return;
        }else if(k==0||n==0){
            return;
        }

        for(int i=1;i<=9;i++){
            if(!visited[i]){
                visited[i]=true;
                helper(result,k-1,n-i,visited);
                visited[i]=false;
            }
        }
    }

    public static void main(String[]args){
        int k=3,n=9;
        CombinationSum cs=new CombinationSum();
        System.out.println(cs.combinationSum3(k,n));
    }
}

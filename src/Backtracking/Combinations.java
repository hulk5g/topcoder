package Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ksharma
 */
public class Combinations {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result=new ArrayList<>();
        helper(result,new ArrayList<Integer>(),1,n,k);
        return result;
    }

    private void helper(List<List<Integer>> result, ArrayList<Integer> temp, int idx, int n, int k) {
        if(temp.size()==k){
            result.add(new ArrayList<>(temp));
            return;
        }
        for(int i=idx;i<n+1;i++){
            temp.add(i);
            helper(result,temp,i+1,n,k);
            temp.remove(temp.size()-1);
        }
    }

    public static void main(String []args){
        Combinations cs=new Combinations();
        System.out.println(cs.combine(4,2));
    }

}

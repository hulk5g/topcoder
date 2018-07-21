package Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ksharma
 */
public class PalindromePartition {
    public List<List<String>> partition(String s) {
        List<List<String>> result=new ArrayList<>();
        helper(result,new ArrayList<String>(),0,s);
        return result;
    }

    private void helper(List<List<String>> result, ArrayList<String> temp, int idx, String s) {
        if(idx>=s.length()){
            result.add(new ArrayList<>(temp));
            return;
        }
        for(int i=idx;i<s.length();i++){
            if(isPalndrome(s,idx,i)){
                if(idx==i){
                    temp.add(String.valueOf(s.charAt(i)));
                }else{
                    temp.add(s.substring(idx,i+1));
                }
                helper(result,temp,i+1,s);
                temp.remove(temp.size()-1);
            }
        }
    }

    private boolean isPalndrome(String s, int idx, int i) {
        while(idx<=i){
            if(s.charAt(idx)==s.charAt(i)){
                idx++;
                i--;
            }else{
                return false;
            }
        }
        return true;
    }

    public static void main(String [] args){
        PalindromePartition pp=new PalindromePartition();
        System.out.println(pp.partition("aab"));
    }
}

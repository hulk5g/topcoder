package Backtracking;

import java.util.Arrays;

/**
 * @author ksharma
 */
public class Permutation {
    public void permute(String s){
        char [] chars=s.toCharArray();
        Arrays.sort(chars);
        helper(chars,0,s.length());
    }

    private void helper(char[] chars, int idx, int n) {
        if(idx==n){
            System.out.println(String.valueOf(chars));
            return;
        }
        for(int i=idx;i<n;i++){
            if(!isSwapped(chars,i,idx)) {
                swap(i, idx, chars);
                helper(chars, idx + 1, n);
                swap(i, idx, chars);
            }
        }
    }

    private boolean isSwapped(char[] chars, int i, int idx) {
        for(int k = idx; k<i; k++)
            if(chars[i] == chars[k])
                return true;
        return false;
    }

    private void swap(int i, int idx, char[] chars) {
        char c=chars[i];
        chars[i]=chars[idx];
        chars[idx]=c;
    }

    public static void main(String []args){
        Permutation pp=new Permutation();
        pp.permute("abc");
    }
}

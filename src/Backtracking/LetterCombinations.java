package Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ksharma
 */
public class LetterCombinations {
    public List<String> letterCombinations(String digits) {
        String [] keys={"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> result=new ArrayList<>();
        StringBuffer sb=new StringBuffer("");
        helper(result,sb,keys,0,digits);
        return result;
    }

    public void helper(List<String> result, StringBuffer sb,String[] keys, int idx,String digits){
        if(idx>=digits.length()){
            result.add(new String(sb));
            return;
        }

        String letters=keys[Character.getNumericValue(digits.charAt(idx))];
        for(int i=0;i<letters.length();i++){
            sb.append(letters.charAt(i));
            helper(result,sb,keys,idx+1,digits);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public static void main(String []args){
        LetterCombinations lc=new LetterCombinations();
        System.out.println(lc.letterCombinations(""));
    }
}

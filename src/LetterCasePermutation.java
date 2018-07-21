import java.util.ArrayList;
import java.util.List;

/**
 * @author ksharma
 */
public class LetterCasePermutation {
    public List<String> letterCasePermutation(String s) {
        List<String>result=new ArrayList<>();
        backtrack(result,s.toCharArray(),0);
        return result;
    }

    void backtrack(List<String>result, char[] s, int index){
        if(index==s.length){
            result.add(String.valueOf(s));
            return;
        }
        if(!Character.isDigit(s[index])){
            s[index]=Character.toUpperCase(s[index]);
            backtrack(result,s,index+1);
            s[index]=Character.toLowerCase(s[index]);
        }
        backtrack(result,s,index+1);
    }

    public static void main(String []args){
        String s = "a1b2";
        LetterCasePermutation lcp=new LetterCasePermutation();
        System.out.println(lcp.letterCasePermutation(s));
    }
}

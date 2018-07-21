package Backtracking;

import java.util.Arrays;
import java.util.List;

/**
 * @author ksharma
 */
public class WordBreak {
    String word="";
    boolean found;
    public String makeSentence(String s,List<String> dict){
        helper(s,dict,new StringBuilder());
        return word;
    }

    private void helper(String s, List<String> dict,StringBuilder sb) {
        if(s.isEmpty()){
            found=true;
            word=sb.toString();
            return;
        }
        for(int i=0;i<dict.size();i++){
            if(s.startsWith(dict.get(i))){
                String s1=s.substring(dict.get(i).length());
                int len=sb.length();
                sb.append(dict.get(i)).append(s1.isEmpty()?"":" ");
                helper(s1,dict,sb);
                if(found)return;
                sb.setLength(len);
            }
        }
    }

    public static void main(String []args){
        WordBreak wb=new WordBreak();
        String s="thesispartythesisparty";
        List<String>wordDict = Arrays.asList(new String[]{"the", "thesis", "party"});
        System.out.println(wb.makeSentence(s,wordDict));

    }
}

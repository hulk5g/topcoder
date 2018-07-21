package DP;

import java.util.*;

/**
 * @author ksharma
 */
public class WordBreakII {
    public List<String> wordBreak(String s, List<String> wordDict){
        Map<String,List<String>>hm=new HashMap<>();
        return helper(s,hm,wordDict);
    }

    private List<String> helper(String s, Map<String, List<String>> hm, List<String> dict) {
        if(hm.containsKey(s))return hm.get(s);
        List<String> result=new ArrayList<>();
        if(s.length()==0){
            result.add("");
            return result;
        }

        for(int i=0;i<dict.size();i++){
            if(s.startsWith(dict.get(i))){
                String remainS=s.substring(dict.get(i).length());
                List<String> temp=helper(remainS,hm,dict);
                for(String s1:temp){
                    result.add(dict.get(i)+ (s1.isEmpty()?"":" ")+s1);
                }
            }
        }
        hm.put(s,result);
        return result;
    }

    public static void main(String []args){
        WordBreakII wb=new WordBreakII();
        String s = "catsanddog";
        List<String>wordDict = Arrays.asList(new String[]{"cat", "cats", "and", "sand", "dog"});
        System.out.println(wb.wordBreak(s,wordDict));
    }
}

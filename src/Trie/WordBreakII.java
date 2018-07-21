package Trie;

import java.util.*;

/**
 * @author ksharma
 */
public class WordBreakII {

    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set=new HashSet<>(wordDict);
        List<String> result=new ArrayList<>();
        boolean []dp=new boolean[s.length()+1];
        dp[0]=true;
        for(int i=1;i<=s.length();i++){
            for(int j=0;j<i;j++){
                if(dp[j] && set.contains(s.substring(j,i))){
                    dp[i]=true;
                    break;
                }
            }
        }
        if(dp[s.length()]==false)return result;
        findString(result,s,set,0,s.length(),new StringBuilder());
        return result;
    }

    private void findString(List<String> result, String s, Set<String> set,int start,int end,StringBuilder sb) {
        if(start>=end){
            result.add(sb.toString().trim());
            return;
        }
        for(int i=start;i<=end;i++){
            String s1=s.substring(start,i);
            if(set.contains(s1)){
                int length=sb.length();
                sb.append(s1).append(" ");
                findString(result,s,set,i,end,sb);
                sb.setLength(length);
            }
        }
    }

    public static void main(String []args){
        String s = "catsanddog";
        String []wordDict = {"cat", "cats", "and", "sand", "dog"};
        WordBreakII wb=new WordBreakII();
        System.out.println(wb.wordBreak(s, Arrays.asList(wordDict)));
    }
}

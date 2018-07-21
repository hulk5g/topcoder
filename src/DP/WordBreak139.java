package DP;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author ksharma
 */
public class WordBreak139 {
    public boolean wordBreak2(String s, List<String> wordDict){
        int n=s.length();
        Set<String> dict=new HashSet<>(wordDict);
        boolean []dp=new boolean[n+1];
        dp[0]=true;
        for(int i=1;i<=n;i++){
            for(int j=0;j<i;j++){
                if(dp[j] && dict.contains(s.substring(j,i))){
                    dp[i]=true;
                }
            }
        }
        return dp[n];
    }

    public boolean wordBreak1(String s, List<String> wordDict) {
        int n=s.length();
        Set<String> dict=new HashSet<>(wordDict);
        boolean [][]dp=new boolean[n][n];
        for(int i=0;i<n;i++){
            if(dict.contains(String.valueOf(s.charAt(i)))){
                dp[i][i]=true;
            }
        }

        for(int l=2;l<=n;l++){
            for(int i=0;i<n-l+1;i++){
                int j=i+l-1;
                if(dict.contains(s.substring(i,j+1))){
                    dp[i][j]=true;
                }else{
                    for(int k=i+1;k<=j;k++){
                        if(dp[i][k-1] && dp[k][j]){
                            dp[i][j]=true;
                        }
                    }
                }
            }
        }

        return dp[0][n-1];

    }

    public static void main(String []args){
        WordBreak139 wb=new WordBreak139();
        String s = "a";
        String []wordDict = {"a"};
        System.out.println(wb.wordBreak2(s, Arrays.asList(wordDict)));
    }
}

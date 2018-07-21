package DP;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ksharma
 */
public class WrapAroundString {
    public int findSubstringInWraproundString(String p) {
        int n=p.length();
        boolean [][]dp=new boolean[n][n];
        Set<String> set=new HashSet<>();
        for(int k=1;k<=n;k++){
            for(int i=0;i<n-k+1;i++){
                int j=i+k-1;
                if(i==j) {
                    dp[i][j] = true;
                    set.add(p.substring(i,j+1));
                }else if(k==2){
                    int code1=p.codePointAt(i);
                    int code2=p.codePointAt(j);
                    if(code2-code1==1 || code1-code2==25){
                        dp[i][j]=true;
                        set.add(p.substring(i,j+1));
                    }
                }else{
                    dp[i][j]=dp[i][j-1] && dp[i+1][j];
                    if(dp[i][j]){
                        set.add(p.substring(i,j+1));
                    }
                }
            }
        }
        return set.size();
    }

    public static void main(String []args){
        WrapAroundString ws=new WrapAroundString();
        System.out.println(ws.findSubstringInWraproundString("zab"));
    }
}

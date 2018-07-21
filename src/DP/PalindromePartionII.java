package DP;

/**
 * @author ksharma
 */
public class PalindromePartionII {
    public int minCut(String s) {
        int n=s.length();
        boolean [][]dp=new boolean[n][n];
        for(int i=0;i<n;i++){
            dp[i][i]=true;
        }
        for(int i=0;i<n-1;i++){
            if(s.charAt(i)==s.charAt(i+1)){
                dp[i][i+1]=true;
            }
        }
        for(int k=3;k<=n;k++){
            for(int i=0;i<n-k+1;i++){
                int j=i+k-1;
                if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]){
                    dp[i][j]=true;
                }
            }
        }
        if(dp[0][n-1])return 0;
        int c[]=new int[n];
        for(int i=1;i<n;i++){
            c[i]=Integer.MAX_VALUE;
            if(dp[0][i]){
                c[i]=0;
            }else{
                for(int j=0;j<i;j++){
                    if(dp[j+1][i]){
                        c[i]=Math.min(c[i],c[j]+1);
                    }
                }
            }
        }
        return c[n-1];
    }

    public static void main(String []args){
        PalindromePartionII pp=new PalindromePartionII();
        System.out.println(pp.minCut("aab"));
    }
}

package DP;

/**
 * @author ksharma
 */
public class LongestValidParantheses {

    public int longestValidParentheses(String s) {
        int max=0;
        int n=s.length();
        boolean [][]dp=new boolean[n][n];
        for(int i=0;i<n-1;i++){
           if(s.charAt(i)=='(' && s.charAt(i+1)==')'){
               max=2;
               dp[i][i+1]=true;
           }
        }
        for(int l=4;l<=n;l=l+2){
            for(int i=0;i<n-l+1;i++){
                int j=i+l-1;
                if(s.charAt(i)=='(' && s.charAt(j)==')'){
                    if(dp[i+1][j-1]){
                        dp[i][j]=dp[i+1][j-1];
                    }
                    else if(s.charAt(i+1)==')'){
                        dp[i][j]=dp[i+2][j];
                    }
                    else if(s.charAt(j-1)=='('){
                        dp[i][j]=dp[i][j-2];
                    }
                }
                if(dp[i][j]){
                    max=Math.max(max,j-i+1);
                }
            }

        }

     /*   for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(dp[i][j]){
                    max=Math.max(max,j-i+1);
                }
            }
        }*/
        return max;
    }

    public static void main(String []args){
        LongestValidParantheses lv=new LongestValidParantheses();
        System.out.println(lv.longestValidParentheses("((()))())"));
    }
}

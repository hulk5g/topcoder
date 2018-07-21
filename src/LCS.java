/**
 * @author ksharma
 */
public class LCS {
    int []row={-1,-1,0};
    int []col={0,-1,-1};

    public int findLCS(String s1,String s2){
        int dp[][]=new int[s1.length()+1][s2.length()+1];

        for(int i=0;i<=s1.length();i++)
            dp[i][0]=0;

        for(int j=0;j<=s2.length();j++)
            dp[0][j]=0;

        for(int i=1;i<=s1.length();i++){
            for(int j=1;j<=s2.length();j++){

                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.max(dp[i][j],Math.max(dp[i-1][j],dp[i][j-1]));
                }
            }
        }

        return dp[s1.length()][s2.length()];
    }


    public static void main(String []args){
        String s1="sea";
        String s2="eat";
        LCS lcs=new LCS();
        System.out.println(lcs.findLCS(s1,s2));

    }
}

package topcoder.DivII500;

/**
 * @author ksharma
 */
public class RepeatStringEasy {

    public 	int maximalLength(String s){
        int max=0;
        int n=s.length();
        for(int l=1;l<=n;l++){

                String s1=s.substring(0,l);
                String s2=s.substring(l);
                max=Math.max(max,2*longestSubSeq(s1,s2));

        }
        return max;
    }

    private int longestSubSeq(String s1, String s2) {
        int [][]dp=new int[s1.length()+1][s2.length()+1];
        int max=0;
        for(int i=0;i<=s1.length();i++){
            for(int j=0;j<=s2.length();j++){
                if(i==0 || j==0)dp[i][j]=0;
                else if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
                max=Math.max(max,dp[i][j]);
            }
        }
        return max;
    }



    public static void main(String []args){
        RepeatStringEasy rs=new RepeatStringEasy();
        System.out.println(rs.maximalLength("aababbababbabbbbabbabb"));
    }
}

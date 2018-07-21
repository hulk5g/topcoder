package DP;

/**
 * @author ksharma
 */
public class ASCIIDeletion {
    int sum=0;
    public int minimumDeleteSum(String s1, String s2) {
        return recursion(s1,s2);
    }
    private int DP(String s1,String s2){

        int [][]dp=new int[s1.length()+1][s2.length()+1];

        for(int i=0;i<=s1.length();i++){
            for(int j=0;j<=s2.length();j++){
                if (i == 0 && j == 0) dp[i][j] = 0;
                else if (i == 0) dp[i][j] = s2.codePointAt (j - 1) + dp[i][j - 1];
                else if (j == 0) dp[i][j] = s1.codePointAt (i - 1) + dp[i - 1][j];
                else {
                    if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = Math.min(s1.codePointAt(i - 1) + dp[i - 1][j],
                                s2.codePointAt(j - 1) + dp[i][j - 1]);
                    }
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }

    private int recursion(String s1, String s2) {

        return recursionHelper(s1,s2,0,s1.length(),0,s2.length());

    }

    private int recursionHelper(String s1,String s2, int s1Start,int s1End,int s2Start,int s2End){
        int temp=0;
        String tempS1=s1.substring(s1Start,s1End);
        String tempS2=s2.substring(s2Start,s2End);
        if(tempS1.equals(tempS2)) return 0;
        if(tempS1.length()==0 && tempS2.length()!=0){
            for(int i=0;i<tempS2.length();i++){
                temp+=tempS2.codePointAt(i);
                return temp;
            }
        }

        if(tempS1.length()!=0 && tempS2.length()==0){
            for(int i=0;i<tempS1.length();i++){
                temp+=tempS1.codePointAt(i);
                return temp;
            }
        }

        if(s1.charAt(s1Start)==s2.charAt(s2Start)){
            return  recursionHelper(s1,s2,s1Start+1,s1End,s2Start+1,s2End);
        }
        return Math.min(s1.codePointAt(s1Start)+recursionHelper(s1,s2,s1Start+1,s1End,s2Start,s2End),
                s2.codePointAt(s2Start)+recursionHelper(s1,s2,s1Start,s1End,s2Start+1,s2End));

    }

    public static void main(String []args){
        ASCIIDeletion ad=new ASCIIDeletion();
        System.out.println(ad.minimumDeleteSum("a","at"));
    }
}

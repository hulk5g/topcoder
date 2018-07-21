/**
 * @author ksharma
 */
public class LongestPalindromeSubstring {

    static void printSubStr(String str, int low, int high) {
        System.out.println(str.substring(low, high + 1));
    }

    static int longestPalindrome (String str) {

        int n = str.length();
        int maxLength = 1;
        int start=0;
        boolean dp[][] = new boolean[n][n];
        for (int i = 0; i < n; ++i)
            dp[i][i] = true;


        for (int i = 0; i < n - 1; ++i) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                dp[i][i + 1] = true;
                start = i;
                maxLength = 2;
            }
        }

        for (int k = 3; k <= n; ++k) {
            for (int i = 0; i < n - k + 1; ++i)
            {
                int j = i + k - 1;
                if (dp[i + 1][j - 1] && str.charAt(i) ==
                        str.charAt(j)) {
                    dp[i][j] = true;

                    if (k > maxLength) {
                        start = i;
                        maxLength = k;
                    }
                }
            }
        }
        System.out.print("Longest palindrome substring is; "+str.substring(start,start+maxLength));
        return maxLength; // return length of LPS
    }

    public String longestPalSubstr(String s) {
        int n=s.length();
        int maxLength=1;
        int start=0;
        boolean [][]dp=new boolean[n][n];
        for(int i=0;i<n;i++){
            dp[i][i]=true;
        }

        for (int i = 0; i < n - 1; ++i) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                start = i;
                maxLength = 2;
            }
        }

        for(int k=3;k<=n;++k){
            for(int i=0;i<n-k+1;++i){
                int j=i+k-1;
                if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]){
                    dp[i][j]=true;
                    if(k>maxLength){
                        maxLength=k;
                        start=i;
                    }
                }
            }
        }
        return s.substring(start,start+maxLength);
    }

    public static void main(String []args){
        LongestPalindromeSubstring lps=new LongestPalindromeSubstring();
        System.out.println(lps.longestPalSubstr("babad"));
        System.out.println(longestPalindrome ("babad"));
    }
}

package DP;

/**
 * @author ksharma
 */
public class CountPalindromicSubstring {

    public int countSubstrings(String s) {
        return trickyOnePass(s);
    }

    public int trickyOnePass(String s){
        if (s == null || s.length() == 0) return 0;
        int n=s.length();
        int count=0;
        for(int i=0;i<n;i++){
                count+=checkPalindrome(s,i,i+1);
                count+=checkPalindrome(s,i,i);

        }
        return count;
    }

    public int checkPalindrome(String s, int left,int right){
        int count=0;
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
            count++;
        }
        return count;
    }

    public int dp(String s){
        int count=0;
        boolean [][]dp=new boolean[s.length()][s.length()];
        for(int i=0;i<s.length();i++){
            dp[i][i]=true;
            count++;
        }
        for(int i=0;i<s.length()-1;i++){
            if(s.charAt(i)==s.charAt(i+1)){
                dp[i][i+1]=true;
                count++;
            }
        }
        for(int k=3;k<=s.length();k++){
            for(int i=0;i<s.length()-k+1;i++){
                int j=i+k-1;
                if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]){
                    dp[i][j]=true;
                    count++;
                }
            }
        }
        return count;
    }

    public int recursion(String s){
        char[]charArray=s.toCharArray();
        return recursionsHelper(charArray, 0,s.length());
    }

    public int recursionsHelper(char[]charArray, int begin,int end){
        if(begin>=end) return 0;
        if(isPalindrome(charArray,begin,end)){
            return 1+recursionsHelper(charArray,begin+1,end)+recursionsHelper(charArray,begin,end-1)
                    -recursionsHelper(charArray,begin+1,end-1);
        }
        return recursionsHelper(charArray,begin+1,end)+recursionsHelper(charArray,begin,end-1)
                -recursionsHelper(charArray,begin+1,end-1);
    }

    private boolean isPalindrome(char[] charArray, int begin, int end) {
        while(begin<end){
            if(charArray[begin]==charArray[end-1]){
                begin++; end--;
            }else{
                return false;
            }

        }
        return true;
    }

    public static void main(String []args){
        CountPalindromicSubstring cp=new CountPalindromicSubstring();
        System.out.println(cp.countSubstrings("aaa"));
    }
}

package topcoder.DivII500;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @author ksharma
 */
public class MatchNumbersEasy {
    //int max=0;
    int []dp;
    HashMap<Integer, BigInteger> history = new HashMap<Integer, BigInteger>();

    public String maxNumber(int[] matches, int n) {
        return search(matches, n).toString();
    }

    BigInteger search(int matches[], int left) {
        if (history.containsKey(left)) {
            return history.get(left);
        }
        BigInteger result = BigInteger.ZERO;
        for (int i = 0; i < matches.length; i++) {
            if (matches[i] <= left) {
                BigInteger next = search(matches, left - matches[i]).multiply(
                        new BigInteger("10")).add(new BigInteger(i + ""));
                if (next.compareTo(result) > 0) {
                    result = next;
                }
            }
        }
        history.put(left, result);
        return result;
    }

    public String usingDP(int []matches,int n){
        String [][]dp=new String[matches.length+1][n+1];
        for(int i=0;i<=matches.length;i++){
            Arrays.fill(dp[i],"");
        }
        for (int i = 1; i <=matches.length; ++i) {
            dp[i][matches[i-1]] = (i-1)+"";
        }
        for(int i=1;i<=matches.length;i++){
            for(int j=0;j<=n;j++){
                dp[i][j]=dp[i-1][j];
                if(matches[i-1]<=j){
                    int a=dp[i][j].isEmpty()?0:Integer.parseInt(dp[i][j]);
                    String newNum=(i-1)+dp[i][j-matches[i-1]];
                    int b=newNum.isEmpty()?0:Integer.parseInt(newNum);
                    if(a<b){
                        dp[i][j]=newNum;
                    }
                }
            }
        }

        return String.valueOf(dp[matches.length][n]);
    }

    public static void main(String[] args) {
        MatchNumbersEasy mn=new MatchNumbersEasy();
        System.out.println(mn.maxNumber(new int[]{6,7,8},21));
    }
}

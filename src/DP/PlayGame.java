package DP;

import java.util.Arrays;

/**
 * @author ksharma
 */
public class PlayGame {
    public int winRecursive(int n){
        if(n==0)return -1;
        for(int i=1;i<=Math.sqrt(n);i++){
            if(winRecursive(n-i*i)==-1){
                return i*i;
            }
        }
        return -1;
    }


    public int win(int n){
        int []dp=new int[n+1];
        Arrays.fill(dp,-1);
        for(int i=1;i<=n;i++){
            for(int j=1;j<=Math.sqrt(i);j++){
                if(dp[i-j*j]==-1) {
                    dp[i] = j * j;
                }
            }
        }
        return dp[n];
    }

    public static void main(String []args){
        PlayGame pg=new PlayGame();
        System.out.println(pg.winRecursive(3));
    }
}

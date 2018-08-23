package topcoder.DivII500;

import java.util.Arrays;

/**
 * @author ksharma
 */
public class ChangingSounds {
    int dp[][];
    public int maxFinal(int[] changeIntervals, int beginLevel, int maxLevel){
        dp=new int[maxLevel+1][changeIntervals.length+1];
        for(int i=0;i<=maxLevel;i++){
            Arrays.fill(dp[i],-2);
        }

        return helper(0,maxLevel,beginLevel,0,changeIntervals);
    }

    public int helper(int min,int max, int curr, int idx,int []changeIntervals){
        if(curr>max||curr<min)return -1;
        if(idx==changeIntervals.length){
            return curr;
        }
        if(dp[curr][idx]!=-2)return dp[curr][idx];
        //int maxVol=-1;
        //for(int i=idx;i<changeIntervals.length;i++){
            dp[curr][idx]=Math.max(helper(min,max,curr+changeIntervals[idx],idx+1,changeIntervals),
                        helper(min,max,curr-changeIntervals[idx],idx+1,changeIntervals));
        //}

        return dp[curr][idx];

    }

    public static void main(String[] args) {
        ChangingSounds cs=new ChangingSounds();
        System.out.println(cs.maxFinal(new int[]{74,39,127,95,63,140,99,96,154,18,137,162,14,88},40,243));
    }
}

package Backtracking;

import java.util.Arrays;

/**
 * @author ksharma
 */
public class BallArrangements {
    //int c;
    int dp[][][][];
    int countUtil(int p, int q, int r)
    {
        int n=p+q+r;
        dp=new int[100][100][100][3];
        int count[]={p,q,r};

        for (int[][][] row : dp)
        {
            for (int[][] innerRow : row)
            {
                for (int[] innerInnerRow : innerRow)
                {
                    Arrays.fill(innerInnerRow, -1);
                }
            }
        };

        return helper(count,0,-1,n);
       // return c;
    }

    private int helper(int []count, int level, int lastBall,int n) {

        if(lastBall>0 && count[0]>=0 && count[1] >=0 && count[2]>=0 && dp[count[0]][count[1]][count[2]][lastBall]!=-1){
            return dp[count[0]][count[1]][count[2]][lastBall];
        }
        if(level==n){
            return 1;
        }
        int c=0;
        for(int i=0;i<3;i++){
            if(i!=lastBall && count[i]>0){
                count[i]=count[i]-1;
                c+=helper(count,level+1,i,n);
                count[i]=count[i]+1;
                dp[count[0]][count[1]][count[2]][i]=c;
            }
        }
        return c;
    }

    public static void main(String []args){
        BallArrangements ba=new BallArrangements();
        System.out.println(ba.countUtil(2,2,1));
    }
}

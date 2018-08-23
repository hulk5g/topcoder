package topcoder.DivII500;

import java.util.Arrays;

/**
 * @author ksharma
 */
public class StandInLine {

    public int[] reconstruct(int[] left){
        int n=left.length;
        int []ans=new int[n];
        Arrays.fill(ans,-1);
        for(int i=1;i<=n;i++){
            int noOfTallers=left[i-1];
            int currHeight=i;
            fillfirstEmpty(noOfTallers,currHeight,ans);
        }
        return ans;
    }

    private void fillfirstEmpty(int noOfTallers, int currHeight, int[] ans) {
        if(ans[noOfTallers]==-1){
            ans[noOfTallers]=currHeight;
        }else{
            for(int i=noOfTallers;i<ans.length;i++){
                if(ans[i]==-1){
                    ans[i]=currHeight;
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        StandInLine si=new StandInLine();
        int[]result=si.reconstruct(new int[]{6, 1, 1, 1, 2, 0, 0 }


        );
        for(int i:result){
            System.out.print(i+",");
        }
    }
}

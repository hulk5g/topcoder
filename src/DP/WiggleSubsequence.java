package DP;

import java.util.Arrays;

/**
 * @author ksharma
 */
public class WiggleSubsequence {
    public int wiggleMaxLength(int[] nums) {
        int n=nums.length;
        int[] lis=new int[n];
        int[] lds=new int[n];
        Arrays.fill(lis,1);
        Arrays.fill(lds,1);
        int max= Integer.MIN_VALUE;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    lis[i]=Math.max(lis[i],lds[j]+1);
                    max= Math.max(max,lis[i]);
                }else if(nums[i]<nums[j]){
                    lds[i]=Math.max(lds[i],lis[j]+1);
                    max=Math.max(max,lds[i]);
                }
            }
        }
        return max;
    }

    public static void main(String []args){
        WiggleSubsequence ws=new WiggleSubsequence();
        System.out.println(ws.wiggleMaxLength(new int[]{1,2,3,4,5,6,7,8,9}));
    }
}

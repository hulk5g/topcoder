package topcoder.DivII500;

import java.util.Arrays;

/**
 * @author ksharma
 */
public class VolumeDiscount {
    public int bestDeal(String[] priceList, int quantity){
        int []dp=new int[quantity+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=1;i<=quantity;i++){
            for(int j=0;j<priceList.length;j++){
                String []unitPrice=priceList[j].split(" ");
                int units=Integer.parseInt(unitPrice[0]);
                int up=Integer.parseInt(unitPrice[1]);
                if(i>=units){
                    dp[i]=Math.min(dp[i],dp[i-units]+up);
                }else{
                    dp[i]=Math.min(dp[i],up);
                }

            }
        }
        return dp[quantity];
    }



    public static void main(String[] args) {
        VolumeDiscount vd=new VolumeDiscount();
        System.out.println(vd.bestDeal(new String[]{"2 272","1 166","10 993"} ,81));
    }
}

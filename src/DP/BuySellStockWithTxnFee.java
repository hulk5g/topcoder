package DP;

/**
 * @author ksharma
 */
public class BuySellStockWithTxnFee {

    public int maxProfit(int[] prices, int fee) {
        long t_ik0=0;
        long t_ik1=Integer.MIN_VALUE;
        for(int i=0;i<prices.length;i++){
            long temp=t_ik0;
            t_ik0=Math.max(t_ik0,t_ik1+prices[i]-fee);
            t_ik1=Math.max(t_ik1,temp-prices[i]);
        }
        return (int)t_ik0;
    }

    public static void main(String []args){
        int[]prices={1, 3, 2, 8, 4, 9};
        BuySellStockWithTxnFee bs=new BuySellStockWithTxnFee();
        System.out.println(bs.maxProfit(prices,2));

    }
}

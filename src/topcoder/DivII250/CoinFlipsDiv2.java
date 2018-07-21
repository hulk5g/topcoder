package topcoder.DivII250;

/**
 * @author ksharma
 */
public class CoinFlipsDiv2 {
    public  int countCoins(String state){
        char []arr=state.toCharArray();
        int n=arr.length;
        int count=0;
        for(int i=0;i<arr.length;i++){
            if((i!=n-1 && arr[i]!=arr[i+1]) ||(i!=0 && arr[i]!=arr[i-1])){
                count++;
            }
        }
        return count;
    }

    public static void main(String []args){
        CoinFlipsDiv2 cp=new CoinFlipsDiv2();
        System.out.println(cp.countCoins("HHTHHH"));
    }
}

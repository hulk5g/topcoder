/**
 * @author ksharma
 */
public class RabbitInForest {
    public int numRabbits(int[] answers) {
        int[] count = new int[1000];
        for (int x: answers) count[x]++;

        int ans = 0;
        for (int k = 0; k < 1000; ++k) {
            int t = Math.floorMod(-count[k], k + 1);
            ans += t + count[k];
        }
        return ans;
    }

    public static void main(String[] args){
        RabbitInForest rf=new RabbitInForest();
        int []a={5,5,5,5,5,5,5,5,5,5,5,5,5};
        System.out.println(rf.numRabbits(a));
    }


}

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by ksharma on 5/5/17.
 */
public class MaxScore {
    static long getMaxScore(long[] a){
        Arrays.sort(a);
        System.out.println(a);
        long runningSum=0;
        long score=0;
        long modResult=0;
        int n=a.length-1;
        int m=a.length;
        while(n>=0){
            if(n>0) {
                score = score + (runningSum % a[n - 1]);
                runningSum = runningSum + a[n - 1];
            }
            score=score+(runningSum%a[n]);
            runningSum=runningSum+a[n];
            n=n-2;
        }

        return score;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[] a = new long[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextLong();
        }
        long maxScore = getMaxScore(a);
        System.out.println(maxScore);
    }
}

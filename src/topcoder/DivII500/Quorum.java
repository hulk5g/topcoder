package topcoder.DivII500;

import java.util.Arrays;

/**
 * @author ksharma
 */
public class Quorum {

    public 	int count(int[] arr, int k){
        Arrays.sort(arr);
        int sum=0;
        for(int i=0;i<k;i++){
            sum+=arr[i];
        }
        return sum;
    }
}

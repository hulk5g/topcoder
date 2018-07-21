package topcoder.DivII250;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ksharma
 */
public class HalvingEasy {
    public int count(int[] S, int T){
        Map<Integer,Boolean> map=new HashMap<>();
        int count=0;

        for(int i=0;i< S.length;i++){
           count+=helper(S[i],T,map);
        }
        return count;
    }

    private int helper(int i, int t, Map<Integer, Boolean> map) {
        if(i==t || i%t==0){
            map.put(i,true);
            return 1;
        }else if(i<t){
            return 0;
        }
        if(map.containsKey(i)){
            return 1;
        }
        int count= helper(i/2,t,map);
        if(count>0){
            map.put(i,true);
        }
        return count;
    }
}

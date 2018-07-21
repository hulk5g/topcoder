package topcoder.DivII500;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ksharma
 */
public class LastDigit {
    Map<Long,Long>hm=new HashMap<>();
    public long findX(long S){
        return helper(S,0,0,1);
        //return num;
    }

    public long helper(long target, long currSum,long result,int idx){
        if(currSum==target){
            hm.put(target,result);
            return result;
        }else if(hm.containsKey(target))return hm.get(target);
        else if(currSum>target)return -1;
        for(int i=idx;i<=9;i++){

            long temp=helper(target,currSum+result*10+i,result*10+i,0);
            if(temp!=-1){
                hm.put(target,temp);
                return temp;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        LastDigit ld=new LastDigit();
        System.out.println(ld.findX(137174210616796l));
    }
}

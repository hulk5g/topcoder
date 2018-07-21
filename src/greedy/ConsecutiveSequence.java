package greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ksharma
 */
public class ConsecutiveSequence {
    public boolean isPossible(int[] nums) {
        Map<Integer,List<Integer>>mp=new HashMap<>();
        int currSeqSize=1;
        int currSeqLastInt=nums[0];
        int maxSeqSize=0;
        for(int i=1;i<nums.length;i++) {
            if (nums[i] - currSeqLastInt == 1) {
                currSeqSize++;
                currSeqLastInt = nums[i];
            } else {
                mp.putIfAbsent(currSeqSize,new ArrayList<>());
                List<Integer>temp=mp.get(currSeqSize);
                temp.add(currSeqLastInt);
                mp.put(currSeqSize,temp);
                maxSeqSize=Math.max(maxSeqSize,currSeqSize);
                int j=1;
                for(;j<=maxSeqSize;j++){
                    if(mp.get(j)!=null && mp.get(j).size()>0){
                        List<Integer>lastDigitSeq=mp.get(j);
                        for(int k=0;k<lastDigitSeq.size();k++){
                            if(nums[i]-lastDigitSeq.get(k)==1){
                                currSeqLastInt=nums[i];
                                currSeqSize=j+1;
                                lastDigitSeq.remove(k);
                                j=maxSeqSize+2;
                            }
                        }
                    }
                }
                if(j==maxSeqSize+1){
                    //no suitable seq found. start a new one with size=1
                    currSeqSize=1;
                    currSeqLastInt=nums[i];
                }
            }
        }

        if((mp.get(1)!=null && mp.get(1).size()!=0) || (mp.get(2)!=null && mp.get(2).size()!=0) || currSeqSize<3){
            return false;
        }
        return true;
    }

    public static void main(String []args){
        ConsecutiveSequence cs=new ConsecutiveSequence();
        int [] input= {4,5,6,7,7,8,8,9,10,11};
        System.out.println(cs.isPossible(input));
    }
}

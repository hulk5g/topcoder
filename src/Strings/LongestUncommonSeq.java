package Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ksharma
 */
public class LongestUncommonSeq {
    public int findLUSlength(String[] strs) {
        Map<Integer,List<String>>mp=new HashMap<>();
        int maxSize=0;
        for(String s:strs){
            int l=s.length();
            mp.putIfAbsent(l,new ArrayList<>());
            mp.get(l).add(s);
            maxSize=Math.max(maxSize,l);
        }
        List<String>maxSizeStrs=mp.get(maxSize);
        if(maxSizeStrs.size()==1){
            return maxSize;
        }
        Map<String,Integer>occurence=new HashMap<>();
        for(String str:maxSizeStrs){
            occurence.put(str,occurence.getOrDefault(str,0)+1);
        }
        for(Map.Entry<String,Integer>entry:occurence.entrySet()){
            if(entry.getValue()==1)
                return maxSize;
        }
        return -1;
    }

    public static void main(String []args){
        LongestUncommonSeq lu=new LongestUncommonSeq();
        String []input={"aba", "cdc", "eae"};
        System.out.println(lu.findLUSlength(input));
    }
}

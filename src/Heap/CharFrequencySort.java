package Heap;

import java.util.*;

/**
 * @author ksharma
 */
public class CharFrequencySort {

    public String frequencySort(String s) {
        Map<Character,Integer> mp=new LinkedHashMap<>();
       for(int i=0;i<s.length();i++){
           mp.put(s.charAt(i),mp.getOrDefault(s.charAt(i),0)+1);
       }
        List<Map.Entry<Character,Integer>> lis=new LinkedList<>(mp.entrySet());
        Collections.sort(lis, (o1, o2) -> o2.getValue()-o1.getValue());
        StringBuilder result=new StringBuilder();
        for(Map.Entry<Character,Integer> entry:lis){
            int count=entry.getValue();
            while(count>0){
                result.append(entry.getKey());
                count--;
            }
        }
        return result.toString();
    }

    public static void main(String [] args){
        CharFrequencySort fs=new CharFrequencySort();
        System.out.println(fs.frequencySort("tree"));
    }
}

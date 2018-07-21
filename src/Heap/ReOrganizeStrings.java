package Heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author ksharma
 */
public class ReOrganizeStrings {

    public String reorganizeString(String S) {

       Map<Character,Integer> mp=new HashMap<>();
       for(int i=0;i<S.length();i++){
           mp.put(S.charAt(i),mp.getOrDefault(S.charAt(i),0)+1);
       }
       PriorityQueue<Map.Entry<Character,Integer>>pq=new PriorityQueue<>((o1, o2) -> o2.getValue().compareTo(o1.getValue()));
        pq.addAll(mp.entrySet());
        if(pq.peek().getValue()==1)return S;
        StringBuilder result=new StringBuilder();
        char[]charArray=new char[S.length()];
        char prevChar='$';
        while(!pq.isEmpty()){
            Map.Entry<Character,Integer>top1=pq.poll();
            Map.Entry<Character,Integer>top2=null;
            if(prevChar==top1.getKey())return "";
            result.append(top1.getKey());
            top1.setValue(top1.getValue()-1);
            prevChar=top1.getKey();
            if(!pq.isEmpty()){
                top2=pq.poll();
                result.append(top2.getKey());
                top2.setValue(top2.getValue()-1);
                prevChar=top2.getKey();

            }
            if(top1.getValue()>0){
                pq.offer(top1);
            }
            if(top2!=null && top2.getValue()>0){
                pq.offer(top2);
            }
        }
        return result.toString();
    }

    public static void main(String []args){
        ReOrganizeStrings ro=new ReOrganizeStrings();
        System.out.println(ro.reorganizeString("aabb"));
    }
}

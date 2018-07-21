package topcoder.DivII250;

import java.util.*;
public class DeckOfCards{
    public  String IsValid(int n, int[] value, String suit){
        boolean [] arr=new boolean[26];
        for(int i=0;i<suit.length();i++){
            arr[suit.charAt(i)-'a']=true;
        }

        Map<String,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            if(map.containsKey(value[i]+"_"+suit.charAt(i))) return "Not Perfect";
            map.put(String.valueOf(value[i]+"_"+suit.charAt(i)),1);
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(!map.containsKey(String.valueOf(value[i]+"_"+suit.charAt(j)))) return "Not Perfect";
            }
        }
        return "Perfect";
    }

    public static void main(String []args){
        DeckOfCards dc=new DeckOfCards();
        System.out.println(dc.IsValid(4,new int[]{1,2,3,4},"hhcc"));
    }
}

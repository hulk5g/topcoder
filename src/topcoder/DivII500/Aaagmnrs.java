package topcoder.DivII500;

import java.util.*;

/**
 * @author ksharma
 */
public class Aaagmnrs {
    public String[] anagrams(String[] phrases){
        Set<String> set=new HashSet<>();
        String[]result=new String[phrases.length];
        int i=0;
        for(String s:phrases){
            String ts=s.replace(" ","").toLowerCase();
            char []arr=ts.toCharArray();
            Arrays.sort(arr);
            String toWord=String.valueOf(arr);
            if(!set.contains(toWord)){
                result[i]=s;
                set.add(toWord.toLowerCase());
                i++;
            }

        }
       return result;

    }

    public static void main(String[] args) {
        Aaagmnrs aa=new Aaagmnrs();
        System.out.println(aa.anagrams(new String[]{ "Radar ghost jilts Kim", "patched hers first",
                "DEPTH FIRST SEARCH", "DIJKSTRAS ALGORITHM" } ));
    }
}

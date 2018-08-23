package topcoder.DivII500;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ksharma
 */
public class IsomorphicWords {

    public int countPairs(String[] words){
        int count=0;
        for(int i=0;i<words.length-1;i++){
            for(int j=i+1;j<words.length;j++){
                if(isIsomorphic(words[i],words[j]))count++;
            }
        }
        return count;
    }

    private boolean isIsomorphic(String word, String word1) {
        Map<Character,Character>map=new HashMap<>();
        Map<Character,Character>reverseMap=new HashMap<>();
        for(int i=0;i<word.length();i++){
            char c=word.charAt(i);
            char c1=word1.charAt(i);
            if(map.containsKey(c) && map.get(c)!=c1)return false;
            if(reverseMap.containsKey(c1) && reverseMap.get(c1)!=c)return false;
            else{
                map.put(c,c1);
                reverseMap.put(c1,c);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsomorphicWords iw=new IsomorphicWords();
        System.out.println(iw.countPairs(new String[]{ "cacccdaabc", "cdcccaddbc", "dcdddbccad", "bdbbbaddcb",
                "bdbcadbbdc", "abaadcbbda", "babcdabbac", "cacdbaccad",
                "dcddabccad", "cacccbaadb", "bbcdcbcbdd", "bcbadcbbca" }


        ));
    }
}

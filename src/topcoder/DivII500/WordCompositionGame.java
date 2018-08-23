package topcoder.DivII500;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ksharma
 */
public class WordCompositionGame {
    public 	String score(String[] listA, String[] listB, String[] listC){
        Map<String, Integer>freq=new HashMap<>();
        fillMap(freq,listA);
        fillMap(freq,listB);
        fillMap(freq,listC);
        int a,b,c;
        a=countScore(listA,freq);
        b=countScore(listB,freq);
        c=countScore(listC,freq);
        String result=String.valueOf(a)+"/"+String.valueOf(b)+"/"+String.valueOf(c);
        return result;
    }

    private int countScore(String[] listA, Map<String, Integer> freq) {
        int sum=0;
        for(String s:listA){
            int val=freq.get(s);
            if(val==1)sum+=3;
            else if(val==2)sum+=2;
            else sum+=1;
        }
        return sum;
    }

    private void fillMap(Map<String, Integer> freq, String[] listA) {
        for(String s:listA){
            freq.putIfAbsent(s,0);
            freq.put(s,freq.get(s)+1);
        }
    }

    public static void main(String[] args) {
        WordCompositionGame wc=new WordCompositionGame();
        System.out.println(wc.score(new String[]{"cat", "dog", "pig", "mouse"},
        new String[]{"cat", "pig"},
        new String[]{"dog", "cat"}));
    }
}

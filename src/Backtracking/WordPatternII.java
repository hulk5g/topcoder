package Backtracking;

import java.util.*;

/**
 * @author ksharma
 */
public class WordPatternII {
    public boolean wordPatternMatch(String pattern, String str) {
        Map<Character,String>hm=new HashMap<>();
        Set<String>set=new HashSet<>();
        boolean b= helper(hm,pattern,str,0,0,set);
        return b;
    }

    public boolean helper(Map<Character,String>hm,String p,String s, int pIdx,int sIdx,Set<String>set){
        if(pIdx==p.length() && sIdx==s.length()) return true;
        if(pIdx==p.length() || sIdx==s.length())return false;
        char pChar=p.charAt(pIdx);
        if(hm.containsKey(pChar)){
            String remain=s.substring(sIdx);
            if(!remain.startsWith(hm.get(pChar))) return false;
           return helper(hm,p,s,pIdx+1,sIdx+hm.get(pChar).length(),set);
        }
        for(int i=sIdx;i<s.length();i++){
            String s1=s.substring(sIdx,i+1);
            if(set.contains(s1))continue;
            hm.put(pChar,s1);
            set.add(s1);
            if(helper(hm,p,s,pIdx+1,sIdx+s1.length(),set)){
                return true;
            }
            hm.remove(pChar);
            set.remove(s1);
        }
        return false;
    }

    public static void main(String []args){
        WordPatternII wp=new WordPatternII();
        System.out.println(wp.wordPatternMatch("abab","redblueredblue"));

    }
}

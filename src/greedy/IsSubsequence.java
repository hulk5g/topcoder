package greedy;

import java.util.*;

/**
 * @author ksharma
 */
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        return solution2(s,t);

    }

    /**
     * Preprocess string t such that keep an index of each alphabet where it is occuring first after each position in
     * string t.
     * Query TC will be 100B* O(m)
     * @param s
     * @param t
     * @return
     */
    private boolean solution2(String s,String t){
        int [][] dp=new int[26][t.length()+1];
        for(int i=0;i<26;i++){
            Arrays.fill(dp[i],-1);
            dp[i][t.length()]=t.length();
        }
        for(int i=0;i<t.length();i++){
            dp[t.charAt(i)-'a'][i]=i;
        }

        for(int i=0;i<26;i++){
            for(int j=t.length()-1;j>=0;j--){
                if(dp[i][j]==-1)
                    dp[i][j] = dp[i][j + 1];
            }
        }
        int prevIndex=0;
        for(int i=0;i<s.length();i++){
            if(dp[s.charAt(i)-'a'][prevIndex]>=t.length())return false;
            prevIndex=dp[s.charAt(i)-'a'][prevIndex]+1;
        }
        return true;
    }

    //TC. 100B*O(mlogn) where m is the average string length in incoming query stream. assuming 100B queries
    private boolean solution1(String s,String t){
        Map<Character,List<Integer>>mp=new HashMap<>();
        for(int i=0;i<t.length();i++){
            mp.putIfAbsent(t.charAt(i),new ArrayList<>());
            mp.get(t.charAt(i)).add(i);
        }
        int prevIndex=-1;

        for(int i=0;i<s.length();i++){
            if(!mp.containsKey(s.charAt(i)))return false;
            List<Integer>indexes=mp.get(s.charAt(i));
            prevIndex=binarySearch(indexes,prevIndex);
            if(prevIndex==-1)return false;
            prevIndex++;
        }
        return true;
    }

    private int binarySearch(List<Integer> indexes, int prevIndex) {
        int lo=0;
        int hi=indexes.size()-1;
        while(lo<=hi){
            int mid=(lo+hi)/2;
            if(indexes.get(mid)<prevIndex){
                lo=mid+1;
            }else {
               hi=mid-1;
            }
        }
        if(lo==indexes.size())return -1;
        return indexes.get(lo);
    }

    public static void main(String []args){
        IsSubsequence is=new IsSubsequence();
        String s="abc";
        String t="ahbgdc";
        System.out.println(is.isSubsequence(s,t));
    }
}

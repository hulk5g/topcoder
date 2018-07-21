package graph;

import java.util.*;

/**
 * @author ksharma
 */
public class SimilarStringGroups {
    public int numSimilarGroups(String[] A) {
        int count=0;
        Set<String>visited=new HashSet<>();
        for(int i=0;i<A.length;i++){
            if(!visited.contains(A[i])){
                count++;
                dfs(visited,A[i],A);
            }
        }
        return count;
    }

    private void dfs(Set<String> visited, String s,String[] A) {
        visited.add(s);
        for(int i=0;i<A.length;i++){
            if(!visited.contains(A[i])){
                if(helper(s,A[i])){
                    dfs(visited,A[i],A);
                }
            }
        }
    }

    private boolean helper(String s, String s1) {
        int res=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=s1.charAt(i))res++;
            if(res>2) return false;
        }
        return res==2;
    }

    public static void main(String []args){
        SimilarStringGroups ss=new SimilarStringGroups();
        String []input={"lyx","xyl"};
        System.out.println(ss.numSimilarGroups(input));
    }
}

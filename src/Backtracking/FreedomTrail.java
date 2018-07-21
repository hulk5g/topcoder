package Backtracking;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ksharma
 */
public class FreedomTrail {
    int minSteps=Integer.MAX_VALUE;

    public int findRotateSteps(String ring, String key) {
        Set<Integer>visited=new HashSet<>();
        for(int i=0;i<ring.length();i++){
            visited.clear();
           // visited.add(i);
            helper(ring,key,i,0,i,visited);
        }
        return minSteps==Integer.MAX_VALUE?0:minSteps;
    }

    private void helper(String ring, String key, int ringI, int keyIdx, int currSteps, Set<Integer> visited) {
        if(keyIdx==key.length() || ringI==ring.length() || currSteps>=minSteps){
            return;
        }
       // visited.add(ringI);
        int nextI=0,prevI=0;
        if(ringI==0){
            nextI=ringI+1;
            prevI=ring.length()-1;
        }else if(ringI==ring.length()-1){
            nextI=0;
            prevI=ringI-1;
        }else{
            nextI=ringI+1;
            prevI=ringI-1;
        }
        if(ring.charAt(ringI)==key.charAt(keyIdx)){
            if(keyIdx==key.length()-1){
                minSteps=Math.min(minSteps,currSteps+1);
                return;
            }
            if(!visited.contains(nextI)){
             //   visited.add(nextI);
                helper(ring,key,nextI,keyIdx+1,currSteps+2,visited);
              //  visited.remove(nextI);
            }
            if(!visited.contains(prevI)){
             //   visited.add(prevI);
                helper(ring,key,prevI,keyIdx+1,currSteps+2,visited);
              //  visited.remove(prevI);
            }
        }else{
            if(!visited.contains(nextI)){
               // visited.add(nextI);
                helper(ring,key,nextI,keyIdx,currSteps+1,visited);
              //  visited.remove(nextI);
            }
            if(!visited.contains(prevI)){
             //   visited.add(prevI);
                helper(ring,key,prevI,keyIdx,currSteps+1,visited);
            //    visited.remove(prevI);
            }
        }

    }

    public static void main(String []args){
        FreedomTrail ft=new FreedomTrail();
        System.out.println(ft.findRotateSteps("godding","gd"));
    }
}

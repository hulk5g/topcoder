package graph;

import java.util.*;

/**
 * @author ksharma
 */
public class CourseSchedule2 {
    public boolean canFinish(int numCourses, int[][] p) {
        Map<Integer,List<Integer>>mp=new HashMap<>();
        for(int i=0;i<p.length;i++){
            int node = p[i][0];
            mp.putIfAbsent(node,new ArrayList<>());
            for(int j=1;j<p[0].length;j++){
                int adj = p[i][j];
                mp.putIfAbsent(adj,new ArrayList<>());
                mp.get(node).add(adj);
            }
        }
        int []colors=new int[numCourses+1];
        Arrays.fill(colors,-1);
        for(Integer i:mp.keySet()){
            if(colors[i]==-1){
                if(isCycle(i,colors,mp))return false;
            }
        }
        return true;
    }

    private boolean isCycle(Integer node, int[]colors,Map<Integer,List<Integer>>mp) {
       colors[node]=0;
        for(int i:mp.get(node)){
            if(colors[i]==0){
                return true;
            }
            if(isCycle(i,colors,mp))return true;
        }
        colors[node]=1;
        return false;
    }

    public static void main(String []args){
        CourseSchedule2 cs=new CourseSchedule2();
        int [][]input={{1,0},{0,1}};
        System.out.println(cs.canFinish(2, input));
    }
}

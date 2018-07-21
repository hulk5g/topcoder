package graph;

import java.util.*;

/**
 * @author ksharma
 */
public class EventualSafeState {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        boolean []visited=new boolean[graph.length];
        List<Integer>result=new ArrayList<>();
        Set<Integer>set=new LinkedHashSet<>();
        for(int i=0;i<graph.length;i++){
            set.add(i);
        }
        for(int i=0;i<graph.length;i++){
            if(!visited[i]){
                dfs(i,visited,graph,set);
            }
        }
        result.addAll(set);
        return result;
    }
    public boolean dfs(int node,boolean[]visited,int [][]graph,Set<Integer> set){
        visited[node]=true;
        for(int adj:graph[node]){
            if(!visited[adj] && dfs(adj,visited,graph,set)){
                //cycle exists
                    set.remove(node);
                    return true;

            }else{
                set.remove(node);
                return true;
            }
        }
        return false;
    }

    public static void main(String []args){
        EventualSafeState es=new EventualSafeState();
        int [][]g={{1,2},{2,3},{5},{0},{5},{},{}};
        System.out.println(es.eventualSafeNodes(g));
    }
}

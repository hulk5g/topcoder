package graph;

import java.util.*;

/**
 * @author ksharma
 */
public class RedundantConnection2 {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n=edges.length;
        List<Integer>[]graph=new List[n+1];
        Map<Integer,List<Integer>>parentGraph=new HashMap<>();
        Map<String,Integer>indexMap=new HashMap<>();
        int index=0;
        boolean is2Parent=false;
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        for(int []e:edges){
            graph[e[0]].add(e[1]);
            parentGraph.putIfAbsent(e[1],new ArrayList<>());
            List<Integer>adj=parentGraph.get(e[1]);
            adj.add(e[0]);
            if(adj.size()>1){
                is2Parent=true;
            }
            parentGraph.put(e[1],adj);
            indexMap.put(e[0]+"-"+e[1],index);
            index++;
        }
        boolean isCycle=checkCycle(graph);
        int maxIndex=-1;
        if(!isCycle) {
            for (Integer node : parentGraph.keySet()) {
                if (parentGraph.get(node).size() > 1) {
                    for (int parent : parentGraph.get(node)) {
                        maxIndex = Math.max(maxIndex, indexMap.get(parent + "-" + node));
                    }
                }
            }
            return edges[maxIndex];
        }
        else if(is2Parent){
            for (Integer node : parentGraph.keySet()) {
                if (parentGraph.get(node).size() > 1) {
                    for (int parent : parentGraph.get(node)) {
                        if(parentGraph.get(parent)!=null && parentGraph.get(parent).size()==1){
                            maxIndex=indexMap.get(parent + "-" + node);
                            break;
                        }

                    }
                }
            }
            return edges[maxIndex];
        }

        for (Integer node : parentGraph.keySet()) {
                for (int parent : parentGraph.get(node)) {
                    if(graph[node].size()>0) {
                        maxIndex = Math.max(maxIndex, indexMap.get(parent + "-" + node));
                    }
                }
        }
        return edges[maxIndex];
    }

    private boolean checkCycle(List<Integer>[] graph) {
        int []color=new int[graph.length];
        Arrays.fill(color,-1);
        for(int i=1;i<graph.length;i++){
            if(color[i]==-1) {
                boolean check = dfs(graph, i, color);
                if (check)
                    return true;
            }
        }
        return false;
    }

    private boolean dfs(List<Integer>[] graph,int node, int[] color) {
        List<Integer>adjs=graph[node];
        color[node]=0;
        for(int temp:adjs){
            if(color[temp]==0){
                return true;
            }
            if(color[temp]==-1 && dfs(graph, temp, color)) {
                return true;
            }
        }
        color[node]=1;
        return false;
    }

    public static void main(String []args){
        RedundantConnection2 rc=new RedundantConnection2();
        int [][]input= {{4,1},{1,5},{4,2},{5,1},{4,3}};
        int[]result=rc.findRedundantDirectedConnection(input);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }
}

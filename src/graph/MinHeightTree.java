package graph;

import java.util.*;

/**
 * @author ksharma
 */
public class MinHeightTree {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
       List<Integer>[] g=new List[n];
        Map<Integer,Integer> inDegree=new HashMap<>();
       for(int i=0;i<n;i++){
           g[i]=new ArrayList<>();
       }
       for(int []e:edges){
           g[e[0]].add(e[1]);
           g[e[1]].add(e[0]);

           int d1=inDegree.getOrDefault(e[0],0);
           inDegree.put(e[0],d1+1);

           d1=inDegree.getOrDefault(e[1],0);
           inDegree.put(e[1],d1+1);
       }

       Queue<Integer>q=new LinkedList<>();
        for(Integer k:inDegree.keySet()){
            if(inDegree.get(k)==1){
                q.offer(k);
            }
        }
        List<Integer>res=new ArrayList<>();
        while(!q.isEmpty()){
            res=new ArrayList<>();
            int count=q.size();
            for(int i=0;i<count;i++) {
                int key = q.poll();
                res.add(key);
                inDegree.put(key, inDegree.get(key) - 1);
                for (int adj : g[key]) {
                    int adjInDegree = inDegree.get(adj) - 1;
                    inDegree.put(adj, adjInDegree);
                    if (adjInDegree == 1) {
                        q.offer(adj);
                    }
                }
            }

        }
        return res.size()>0?res:Arrays.asList(0);
    }



    public static void main(String[]args){
        MinHeightTree mh=new MinHeightTree();
        int [][]input={};
        System.out.println(mh.findMinHeightTrees(1, input));
    }
}

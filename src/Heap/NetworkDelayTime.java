package Heap;

import java.util.*;

/**
 * @author ksharma
 */
public class NetworkDelayTime {
    class NodeTime{
        int label;
        int time;
        public NodeTime(int label,int time){
            this.label=label;
            this.time=time;
        }
    }
    public int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer,List<int[]>>mp=new HashMap<>();
        Map<Integer,NodeTime> weightMap=new HashMap<>();
        PriorityQueue<NodeTime>pq=new PriorityQueue<>((a,b)->a.time-b.time);
        for(int [] time:times){
            mp.putIfAbsent(time[0],new ArrayList<>());
            List<int[]> adjs=mp.get(time[0]);
            adjs.add(new int[]{time[1],time[2]});
            mp.put(time[0],adjs);
            if(time[0]==K){
                NodeTime nodeTime=new NodeTime(time[0],0);
                weightMap.put(time[0],nodeTime);
            }else{
                weightMap.putIfAbsent(time[0],new NodeTime(time[0],Integer.MAX_VALUE));
            }
            weightMap.putIfAbsent(time[1],new NodeTime(time[1],Integer.MAX_VALUE));
        }
        pq.add(weightMap.get(K));
        if(weightMap.size()<N)return -1;
        while(!pq.isEmpty()){
            NodeTime node=pq.poll();
            if(mp.containsKey(node.label)) {
                for (int[] adj : mp.get(node.label)) {
                    NodeTime a = weightMap.get(adj[0]);
                    if (a.time > node.time + adj[1]) {
                        a.time = node.time + adj[1];
                        pq.offer(a);
                    }
                }
            }
        }
        int max=Integer.MIN_VALUE;
        for(NodeTime nt:weightMap.values()){
            if(nt.time==Integer.MAX_VALUE){
                return -1;
            }
            max=Math.max(max,nt.time);
        }
        return max;
    }

    public static void main(String []args){
        NetworkDelayTime nd=new NetworkDelayTime();
        int [][]times={{1,2,1},{2,3,7},{1,3,4},{2,1,2}};
        System.out.println(nd.networkDelayTime(times,4,1));
    }
}

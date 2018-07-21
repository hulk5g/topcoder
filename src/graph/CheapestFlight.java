package graph;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author ksharma
 */
public class CheapestFlight {
    class Node{
        int label;
        int price;
        int stops;

        public Node(int label,int price,int stops){
            this.label =label;
            this.price=price;
            this.stops=stops;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer,Map<Integer,Integer>>g=new HashMap<>();
        for(int [] e:flights){
            g.putIfAbsent(e[0],new HashMap<>());
            g.get(e[0]).put(e[1],e[2]);
        }
        Node srcNode=new Node(src,0,K+1);
        PriorityQueue<Node> pq=new PriorityQueue<>((a,b)->Integer.compare(a.price,b.price));
        pq.offer(srcNode);
        while(!pq.isEmpty()){
            Node top=pq.poll();
            if(top.label ==dst) return top.price;
            if(top.stops==0) continue;
            Map<Integer,Integer> adjs=g.get(top.label);
            if(adjs!=null && adjs.size()>0) {
                for (int adj : adjs.keySet()) {
                    Node temp = new Node(adj, top.price + adjs.get(adj), top.stops - 1);
                    pq.offer(temp);
                }
            }
        }
        return -1;
    }

    public static void main(String []args){
        CheapestFlight cf=new CheapestFlight();
        int [][]edges = {{4,1,1},{1,2,3},{0,3,2},{0,4,10},{3,1,1},{1,4,3}};
        System.out.println(cf.findCheapestPrice(5,edges,2,1,1));
    }
}

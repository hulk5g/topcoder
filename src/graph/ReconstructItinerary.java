package graph;

import java.util.*;

/**
 * @author ksharma
 */
public class ReconstructItinerary {

    public List<String> findItinerary(String[][] tickets) {
        LinkedList<String>result=new LinkedList<>();
        Map<String,PriorityQueue<String>>mp=new HashMap<>();
        for(int i=0;i<tickets.length;i++){
            String src=tickets[i][0];
            String dest=tickets[i][1];
            mp.putIfAbsent(src,new PriorityQueue());
            mp.get(src).add(dest);
        }
        dfsUtil("JFK",mp,result);
        return result;
    }

    private void dfsUtil(String s, Map<String, PriorityQueue<String>> mp, LinkedList<String> result) {
        while(mp.containsKey(s) && !mp.get(s).isEmpty()){
            String dest=mp.get(s).poll();
            dfsUtil(dest,mp,result);
        }
        result.addFirst(s);
    }

    public static void main(String []args){
        String [][]route={{"JFK","KUL"},{"JFK","NRT"},{"NRT","JFK"}};
        ReconstructItinerary ri=new ReconstructItinerary();
        System.out.println(ri.findItinerary(route));
    }
}

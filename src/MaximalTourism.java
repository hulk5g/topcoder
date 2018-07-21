import java.util.*;

/**
 * Created by ksharma on 5/5/17.
 */
public class MaximalTourism {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] route = new int[m][2];

        for(int route_i=0; route_i < m; route_i++){
            for(int route_j=0; route_j < 2; route_j++){
                route[route_i][route_j] = in.nextInt();
            }
        }
        System.out.println(findMaxTourism(route));
    }

    private static int findMaxTourism(int[][] route) {
        Map<Integer,List<Integer>> adjacencyList=new HashMap<>();
        Map<Integer,Boolean> visited=new HashMap<>();
        for(int route_i=0; route_i < route.length; route_i++){

                if(visited.get(route[route_i][0])==null){
                    visited.put(route[route_i][0],false);
                }
                if(visited.get(route[route_i][1])==null){
                    visited.put(route[route_i][1],false);
                }
                if(adjacencyList.get(route[route_i][0])==null){
                    List<Integer> edges=new ArrayList<>();
                    edges.add(route[route_i][1]);
                    adjacencyList.put(route[route_i][0], edges);
                }else{
                    List<Integer> edges=adjacencyList.get(route[route_i][0]);
                    edges.add(route[route_i][1]);
                    adjacencyList.put(route[route_i][0], edges);
                }

                if(adjacencyList.get(route[route_i][1])==null){
                    List<Integer> edges=new ArrayList<>();
                    edges.add(route[route_i][0]);
                    adjacencyList.put(route[route_i][1], edges);
                }else{
                    List<Integer> edges=adjacencyList.get(route[route_i][1]);
                    edges.add(route[route_i][0]);
                    adjacencyList.put(route[route_i][1], edges);
                }
        }

        Set<Integer> visitedKeys=visited.keySet();
        Iterator<Integer>visitedIt=visitedKeys.iterator();
        int max=0;
        Stack<Integer>stack=new Stack<>();

         while(visitedIt.hasNext()){
            Integer key=visitedIt.next();
             Set<Integer> cSet=new HashSet<>();
             cSet=bfs(key,visited,adjacencyList,cSet);
             if(cSet.size()>max){
                 max=cSet.size();
             }
        }
        return max;
    }

    private static Set<Integer> bfs(Integer key, Map<Integer, Boolean> visited, Map<Integer, List<Integer>> adjacencyList, Set<Integer> cSet) {
        if(!visited.get(key)){
            List<Integer> edges=adjacencyList.get(key);
            if(edges!=null){
                visited.put(key,true);
                cSet.add(key);
                for(Integer e:edges){
                    bfs(e,visited,adjacencyList,cSet);
                }
            }
        }
        return cSet;
    }
}

import java.util.*;

public class CircularWalk {

    static int circularWalk(int n, int s, int t, int r_0, int g, int seed, int p){

        Map<Integer,Set<Integer>> adjacencyList= initializeGraph(r_0, g, seed, p,n);
        if(s==t)
            return 0;
        else if(r_0==0 && g==0 && seed==0)
            return -1;

        return bfs(adjacencyList,s,t,n);
    }

    private static int bfs(Map<Integer, Set<Integer>> adjacencyList, int s, int t,int n) {

        Integer[]d=new Integer[n];
        String[]color=new String[n];
        d[s]=0;
        color[s]="gray";
        Queue<Integer>q=new LinkedList<>();
        q.add(s);
        while(!q.isEmpty()){
            Integer u=q.poll();
            adjacencyList.get(u).stream().filter(nbr -> color[nbr] == null).forEach(nbr -> {
                color[nbr] = "gray";
                d[nbr] = d[u] + 1;
                q.add(nbr);
            });
            color[u]="black";
            if("black".equals(color[t])){
                break;
            }
        }
        if(d[t]==null || d[t]==0){
            return -1;
        }
        return d[t];
    }



    private static Map<Integer,Set<Integer>> initializeGraph(int r_0, int g, int seed, int p,int n) {
        Map<Integer,Set<Integer>> adjacencyList=new HashMap<>();
        int nbrLength;
        int prevNbrLength=0;
        for(int i=0;i<n;i++){
            if(i==0){
                nbrLength=r_0;
            }else {
                nbrLength = (prevNbrLength * g + seed) % p;
            }
            prevNbrLength=nbrLength;
            Set<Integer>neighbours=new HashSet<>();
            if(adjacencyList.get(i)!=null){
                neighbours=adjacencyList.get(i);
            }
            int column;
            boolean addedToSet;
            if(nbrLength>0){
                column=i+1;
                int count=0;
                while(count<nbrLength) {
                    if(column==n){
                        column=0;
                    }
                    addedToSet=neighbours.add(column);
                    if(!addedToSet){
                        break;
                    }
                    column++;
                    count++;
                }
                column=i-1;
                count=0;
                while(count<nbrLength) {
                    if(column<0){
                        column=n-1;
                    }
                    addedToSet=neighbours.add(column);
                    if(!addedToSet){
                        break;
                    }
                    column--;
                    count++;
                }
            }
            adjacencyList.put(i,neighbours);
        }
        return adjacencyList;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int s = in.nextInt();
        int t = in.nextInt();
        int r_0 = in.nextInt();
        int g = in.nextInt();
        int seed = in.nextInt();
        int p = in.nextInt();
        int result = circularWalk(n, s, t, r_0, g, seed, p);
        System.out.println(result);
    }
}
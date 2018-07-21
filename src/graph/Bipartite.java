package graph;

import java.util.Arrays;

/**
 * @author ksharma
 */
public class Bipartite {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        char []color=new char[n];
        Arrays.fill(color,'w');
        for(int i=0;i<n;i++){
            if(color[i]=='w'){
                color[i]='r';
                 if(!dfsUtil(i,graph,n,color))return false;
            }
        }
        return true;
    }


    private boolean dfsUtil(int src, int[][] g, int n, char[] color) {
        for(int adj:g[src]){
            if(color[adj]=='w'){
                if(color[src]=='r'){
                    color[adj]='b';
                }else{
                    color[adj]='r';
                }
                return dfsUtil(adj,g,n,color);
            }else if(color[adj]==color[src]){
                return false;
            }
        }
        return true;
    }


    public static void main(String []args){
        Bipartite bp=new Bipartite();
        int[][] input={{4,1},{0,2},{1,3},{2,4},{3,0}};

        System.out.println(bp.isBipartite(input));
    }
}

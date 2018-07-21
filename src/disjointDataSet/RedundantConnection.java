package disjointDataSet;

/**
 * @author ksharma
 */
public class RedundantConnection {
    class UnionFind{
        int [] parent, rank;
        public UnionFind(int n){
            parent=new int[n+1];
            rank=new int[n+1];
            for(int i=0;i<=n;i++){
                parent[i]=i;
                rank[i]=0;
            }
        }

        public int find(int u){
            if(u!=parent[u]){
                parent[u]=find(parent[u]);
            }
            return parent[u];
        }

        public void union(int u, int v){
            int rootU=find(u);
            int rootV=find(v);
            if(rootU==rootV)return;
            if(rank[rootU]<rank[rootV]){
                parent[rootU]=rootV;
            }else{
                parent[rootV]=rootU;
                if(rootU==rootV){
                    rank[rootU]+=1;
                }
            }
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        UnionFind uf=new UnionFind(edges.length);
        int[]ans=new int[2];
        for(int []e:edges){
            int root1=uf.find(e[0]);
            int root2=uf.find(e[1]);
            if(root1==root2){
                ans[0]=e[0];
                ans[1]=e[1];
            }else{
                uf.union(e[0],e[1]);
            }
        }
        return ans;
    }

    public static void main(String []args){
        RedundantConnection rc=new RedundantConnection();
        int [][]input={{1,2}, {2,3}, {3,4}, {1,4}, {1,5}};
        int [] ans=rc.findRedundantConnection(input);
        System.out.println(ans[0]+","+ans[1]);
    }
}

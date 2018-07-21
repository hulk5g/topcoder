package disjointDataSet;

/**
 * @author ksharma
 */
public class FriendCricle {
    class UnionFind{
        int []parent,rank;
        int count;
        public UnionFind(int n){
            parent=new int[n];
            rank=new int[n];
            count=n;
            for(int i=0;i<n;i++){
                parent[i]=i;
            }
        }

        public int find(int x){
            if(x!=parent[x]){
                parent[x]=find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y){
            int rootX=find(x);
            int rootY=find(y);
            if(rootX==rootY) return;
            if(rank[rootX]<rank[rootY]){
                parent[rootX]=rootY;
            }else{
                parent[rootY]=rootX;
                if(rank[rootX]==rank[rootY]){
                    rank[rootX]++;
                }
            }
            count--;
        }
    }
    public int findCircleNum(int[][] M) {
       UnionFind uf=new UnionFind(M.length);
       for(int i=0;i<M.length;i++){
           for(int j=0;j<M[0].length;j++){
               if(M[i][j]==1){
                   uf.union(i,j);
               }
           }
       }
       return uf.count;
    }

    public static void main(String []args){
        int [][]M={{1,1,0},{1,1,1},{0,1,1}};
        FriendCricle fc=new FriendCricle();
        System.out.println(fc.findCircleNum(M));
    }
}

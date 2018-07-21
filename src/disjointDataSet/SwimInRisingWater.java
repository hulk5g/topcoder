package disjointDataSet;

/**
 * @author ksharma
 */
public class SwimInRisingWater {
    private int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    class UnionFind{
        int []parent,rank;


        public UnionFind(int n){
            parent=new int[n];
            rank=new int[n];
            for(int i=0;i<n;i++){
                parent[i]=i;
                rank[i]=0;
            }
        }

        public int find(int x){
            if(x!=parent[x]){
                parent[x]=find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x,int y){
            int rootX=find(x);
            int rootY=find(y);
            if(rootX==rootY)return;
            if(rank[rootX]<rank[rootY]){
                parent[rootX]=rootY;
            }else{
                parent[rootY]=rootX;
                if(rank[rootX]==rank[rootY]){
                    rank[rootX]++;
                }

            }
        }
    }

    public boolean isConnected(UnionFind uf,int n){
        int rootStart=uf.find(0);
        int rootEnd=uf.find(n*n-1);
        if(rootStart==rootEnd)return true;
        return false;
    }

    public int swimInWater(int[][] grid) {
        int N = grid.length;
        UnionFind uf = new UnionFind(N*N);

        int[][] indexes = new int[N * N][2];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                indexes[grid[i][j]][0] = i;
                indexes[grid[i][j]][1] = j;
            }
        }
        for (int i = 0; i < N * N; i++) {
            int[] p = indexes[i];
            for (int[] d : dirs) {
                int x = p[0] + d[0], y = p[1] + d[1];
                if (x < 0 || x >= N || y < 0 || y >=N || grid[x][y] > i) continue;
                // union with smaller neighbors
                uf.union(p[0] * N + p[1], x * N + y);
            }
            if (isConnected(uf,N)) return i;
        }
        return N * N; // dummy. will not be executed
    }

    public static void main(String []args){
        SwimInRisingWater sw=new SwimInRisingWater();
        int [][]grid={{0, 1 , 2 , 3  ,4},
                     {24, 23, 22, 21,  5},
                     {12, 13, 14, 15, 16},
                     {11, 17, 18, 19, 20},
                     {10,  9, 8 , 7,  6}};
        System.out.println(sw.swimInWater(grid));
    }
}

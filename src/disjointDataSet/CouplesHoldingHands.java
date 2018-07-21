package disjointDataSet;

/**
 * @author ksharma
 */
public class CouplesHoldingHands {
    class UnionFind{
        int [] parent,rank;
        int count;
        public UnionFind(int n){
            parent=new int[n];
            rank=new int[n];
            for(int i=0;i<n;i++){
                parent[i]=i;
                rank[i]=0;
            }
        }

        public int find(int x){
            if(x !=parent[x]){
                parent[x]=find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y){
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
    public int minSwapsCouples(int[] row) {
        UnionFind uf=new UnionFind(row.length);
        for(int i=0;i<row.length-1;i+=2){
            uf.union(row[i],row[i+1]);
        }

        for(int i=0;i<row.length-1;i+=2){
            int rootX=uf.find(i);
            int rootY=uf.find(i+1);
            if(rootX!=rootY){
                uf.union(i,i+1);
                uf.count++;
            }
        }
        return uf.count;
    }

    public static void main(String []args){
        CouplesHoldingHands ch=new CouplesHoldingHands();
        int []row = {0, 2, 1, 3};
        System.out.println(ch.minSwapsCouples(row));
    }
}

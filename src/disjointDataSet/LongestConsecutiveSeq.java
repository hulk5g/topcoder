package disjointDataSet;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author ksharma
 */
public class LongestConsecutiveSeq {
    class UnionFind{
        int []parent,rank;
        Map<Integer,Integer> countMap=new HashMap<>();

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

        public int getMax(){
            int max=Integer.MIN_VALUE;
            for(int i=0;i<parent.length;i++){
                int root=find(i);
                countMap.put(root,countMap.getOrDefault(root,0)+1);
            }
            for(Map.Entry<Integer,Integer> entry: countMap.entrySet()){
                if(max<entry.getValue()){
                    max=entry.getValue();
                }
            }
            return max;
        }
    }
    //using union -find
    public int longestConsecutive(int[] nums) {
        UnionFind uf= new UnionFind(nums.length);
        Map<Integer,Integer>indexMap=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            indexMap.putIfAbsent(nums[i],i);
        }
        for(int i=0;i<nums.length;i++){
            int a=nums[i];
            if(indexMap.containsKey(a+1)){
                uf.union(indexMap.get(a),indexMap.get(a+1));
            }
            if(indexMap.containsKey(a-1)){
                uf.union(indexMap.get(a),indexMap.get(a-1));
            }
        }
        return uf.getMax();
    }

    //using sets
    public int longestConsecutive2(int[] nums) {
        Set<Integer> set=new HashSet<>();
        int max=0;
       for(int a:nums){
           set.add(a);
       }
       for(int a:nums){
           if(!set.contains(a-1)){
               int y=a+1;
               while(set.contains(y)){
                   y++;
               }
               max=Math.max(max,y-a);
           }
       }
       return max;
    }

    public static void main(String []args){
        int []seq={-8,7,3,0,8,8,8,-5,-2,-8,-4,6,-7,3,1,7,-6,-9,1,3};
        LongestConsecutiveSeq lc=new LongestConsecutiveSeq();
        System.out.println(lc.longestConsecutive2(seq));
    }
}

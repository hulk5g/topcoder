package graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author ksharma
 */
public class KSimilarStrings {

    public int kSimilarity(String A, String B) {
        Queue<String> Q=new LinkedList<>();
        Set<String> visited=new HashSet<>();
        Q.add(A);
        visited.add(A);
        int k=0;
        while(!Q.isEmpty()){
            int len=Q.size();
            for(int l=0;l<len;l++){
                String s1=Q.poll();
                if(s1.equals(B))return k;
                char []arr=s1.toCharArray();
                for(int i=0;i<arr.length;i++){
                    for(int j=i;j<arr.length;j++){
                        swap(arr,i,j);
                        String toWord=String.valueOf(arr);
                        if(!visited.contains(toWord)){
                            Q.add(toWord);
                        }
                        swap(arr,i,j);
                    }
                }
            }
            k++;
        }
        return k;
    }

    private void swap(char[] arr, int i, int j) {
        char c = arr[i];
        arr[i]=arr[j];
        arr[j]=c;
    }

    public static void main(String []args){
        String A = "ab", B = "ba";
        KSimilarStrings ks=new KSimilarStrings();
        System.out.println(ks.kSimilarity(A,B));
    }
}

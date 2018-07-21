package topcoder.DivII250;

/**
 * @author ksharma
 */
public class PriorityQueue<E> {

    public int findAnnoyance(String S, int[] a){
       // int []d=new int[a.length];
        int total=0;
        for(int i=0;i<a.length;i++){
            if(S.charAt(i)=='b'){
                for(int j=i-1;j>=0;j--){
                    total+=a[j];
                }
            }
        }
        return total;
    }

    public static void main(String []args){
        PriorityQueue pq=new PriorityQueue();
        System.out.println(pq.findAnnoyance("bbeebeebeeeebbb",new int[]{58,517,301,524,79,375,641,152,810,778,222,342,911,313,336}));
    }
}

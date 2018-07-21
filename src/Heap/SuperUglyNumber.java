package Heap;

import java.util.PriorityQueue;

/**
 * @author ksharma
 */
public class SuperUglyNumber {
    class Prime{
        int factor;
        int val;
        int multipler;
        public Prime(int factor,int m){
            this.factor=factor;
            this.multipler=m;
            this.val=this.factor*this.multipler;
        }
    }
    public int nthSuperUglyNumber(int n, int[] primes) {
        if(n==1)return 1;
        PriorityQueue<Prime> pq=new PriorityQueue<>((o1,o2)->o1.val-o2.val);
        for(int i=0;i<primes.length;i++){
            Prime p=new Prime(primes[i],1);
            pq.add(p);
        }
        for(int i=2;i<=n;i++){
            Prime temp=pq.poll();
            if(i==n)return temp.val;
            temp.multipler=temp.val;
            temp.val=temp.factor*temp.multipler;
            pq.offer(temp);

        }
        return -1;
    }
    public static void main(String []args){
        SuperUglyNumber su=new SuperUglyNumber();
        System.out.println(su.nthSuperUglyNumber(5,new int []{2, 7, 13, 19}));
    }
}

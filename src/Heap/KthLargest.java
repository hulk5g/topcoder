package Heap;

import java.util.PriorityQueue;

/**
 * @author ksharma
 */
public class KthLargest {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer>pq=new PriorityQueue<>();
        for(int i=0;i<nums.length;i++){
            pq.offer(nums[i]);
            if(pq.size()>k){
                pq.poll();
            }
        }
        return pq.poll();
    }
    public static void main(String []args){
        KthLargest k=new KthLargest();
        System.out.println(k.findKthLargest(new int[]{3,2,1,5,6,4},2));
    }
}

package Heap;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author ksharma
 */
public class SlidingWindowMax {
    public int[] maxSlidingWindow(int[] nums, int k) {
        return sol2(nums,k);
    }

    public int[] sol2(int []nums,int k){
        if(nums.length==0 ||k==0)return new int[0];
        int []arr=new int[nums.length];
        arr[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            arr[i]=Math.max(arr[i-1],nums[i]);
        }
        int j=0;
        int []result=new int[nums.length-k+1];
        for(int i=0;i<nums.length-k+1;i++){
            result[j++]=arr[i+k-1];
        }
        return result;
    }


    public int [] sol1(int []nums,int k){
        int []result=new int[nums.length-k+1];
        if(nums.length==0 ||k==0)return new int[0];
        PriorityQueue<Integer> pq=new PriorityQueue<>(k,Collections.reverseOrder());
        int j=0;
        for(int i=0;i<k;i++){
            pq.offer(nums[i]);
        }
        result[j]=pq.peek();
        for(int i=k;i<nums.length;i++){
            pq.remove(nums[i-k]);
            pq.offer(nums[i]);
            result[++j]=pq.peek();
        }
        return result;
    }
    public static void main(String []args){
        SlidingWindowMax sw=new SlidingWindowMax();
        int []nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int []result=sw.maxSlidingWindow(nums,k);
        for(int a:result){
            System.out.println(a);
        }
    }
}

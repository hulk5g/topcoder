package stacks;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author ksharma
 */
public class NextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if(nums1==null || nums2==null||nums1.length==0 ||nums2.length==0)return new int[]{};
        Map<Integer,Integer> hm=new HashMap<>();
        int n=nums2.length;
        Stack<Integer>st=new Stack<>();
        int i=0;
        while(i<n){
            if(st.isEmpty() || st.peek()>=nums2[i]){
                st.push(nums2[i++]);
            }else{
                if(!st.isEmpty()){
                    int a =st.pop();
                    hm.put(a,nums2[i]);
                }
            }
        }

        int []result=new int[nums1.length];
        for(i=0;i<nums1.length;i++){

            result[i]=hm.containsKey(nums1[i])?hm.get(nums1[i]):-1;
        }
        return result;
    }

    public static void main(String[] args) {
        NextGreaterElement ng=new NextGreaterElement();
        System.out.println(ng.nextGreaterElement(new int[]{4,1,2},new int[]{1,3,4,2}));
    }
}

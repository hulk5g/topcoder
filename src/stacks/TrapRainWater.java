package stacks;

import java.util.Stack;

/**
 * @author ksharma
 */
public class TrapRainWater {

    public int trap(int[] height) {
        Stack<Integer> st=new Stack<>();
        int ans=0;
        int i=0;
        while(i<height.length){
            if(!st.isEmpty() && height[i]>height[st.peek()]){
                int dip=st.pop();
                while(!st.isEmpty() && height[dip]>height[st.peek()]){
                    st.pop();
                }
                if(!st.isEmpty()) {
                    ans += (i - st.peek() - 1) * (Math.min(height[st.peek()], height[i]) - height[dip]);
                }
                //i--;
            }else{
                st.push(i);
                i++;
            }
            //i++;
        }
        return ans;
    }



            /*if (height == null)
                return 0;
            int ans = 0;
            int size = height.length;
            int[] left_max = new int[size];
            int[] right_max = new int[size];
            left_max[0] = height[0];
            for (int i = 1; i < size; i++) {
                left_max[i] = Math.max(height[i], left_max[i - 1]);
            }
            right_max[size - 1] = height[size - 1];
            for (int i = size - 2; i >= 0; i--) {
                right_max[i] = Math.max(height[i], right_max[i + 1]);
            }
            for (int i = 1; i < size - 1; i++) {
                ans += Math.min(left_max[i], right_max[i]) - height[i];
            }
*/
        //return ans;
    //}/

    public static void main(String[]args){
        TrapRainWater tr=new TrapRainWater();
        int [] h={3,0,0,2,0,4};
        System.out.println(tr.trap(h));
    }
}

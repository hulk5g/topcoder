package stacks;

import java.util.Stack;

/**
 * @author ksharma
 */
public class LargestRectangleHistogram {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st=new Stack<>();
        int i=0;
        int n=heights.length;
        int max=Integer.MIN_VALUE;
        while(i<n){
            if(st.isEmpty() || heights[st.peek()]<=heights[i]){
                st.push(i++);
            }else{
                while(!st.isEmpty() && heights[st.peek()]>heights[i]){
                    int topIdx=st.pop();
                    int area=heights[topIdx]*(!st.isEmpty()?i-st.peek()-1:i);
                    max=Math.max(max,area);
                }
            }
        }

        while(!st.isEmpty()){
            int topIdx=st.pop();
            int area=heights[topIdx]*(!st.isEmpty()?i-st.peek()-1:i);
            max=Math.max(max,area);
        }
        return max;
    }

    public static void main(String []args){
        LargestRectangleHistogram lr=new LargestRectangleHistogram();
        int []height={5,4,3,2,1};
        System.out.println(lr.largestRectangleArea(height));
    }
}

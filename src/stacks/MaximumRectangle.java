package stacks;

import java.util.Stack;

/**
 * @author ksharma
 */
public class MaximumRectangle {
    public int maximalRectangle(char[][] matrix) {
        int maxArea=Integer.MIN_VALUE;
        int []height=new int[matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]=='1'){
                    height[j]+=1;
                }else{
                    height[j]=0;
                }
            }
            int area=largestRectangleArea(height);
            maxArea=Math.max(maxArea,area);
        }
        return maxArea;
    }

    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st=new Stack<>();
        int i=0;
        int n=heights.length;
        int max=Integer.MIN_VALUE;
        while(i<n){
            if(st.isEmpty() || heights[st.peek()]<=heights[i]){
                st.push(i++);
            }else{
               // while(!st.isEmpty() && heights[st.peek()]>heights[i]){
                    int topIdx=st.pop();
                    int area=heights[topIdx]*(!st.isEmpty()?i-st.peek()-1:i);
                    max=Math.max(max,area);
               // }
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
        MaximumRectangle mr=new MaximumRectangle();
        char [][]matrix={
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };
        System.out.println(mr.maximalRectangle(matrix));
    }
}

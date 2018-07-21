package graph;

/**
 * @author ksharma
 */
public class LongestIncreasingPath {
    int max=0;
    int []r={1,-1,0,0};
    int []c={0,0,1,-1};
    public int longestIncreasingPath(int[][] matrix) {
       int[][]dp=new int[matrix.length][matrix[0].length];
      for(int i=0;i<matrix.length;i++){
          for(int j=0;j<matrix[0].length;j++){
              dfs(matrix,i,j,dp);
          }
      }
      return max;
    }

    private int dfs(int[][] matrix, int row, int col,int[][]dp) {
        if(dp[row][col]!=0)return dp[row][col];
        else{
            dp[row][col]=1;
        }
        for(int k=0;k<4;k++){
            int xx=row+r[k];
            int yy=col+c[k];
            if(xx>=0 && xx< matrix.length && yy>=0 && yy<matrix[0].length && matrix[xx][yy]>matrix[row][col]){
                int temp=dfs(matrix,xx,yy,dp);
                if(temp+1>dp[row][col]){
                    dp[row][col]=temp+1;
                }
            }
        }
        max= Math.max(max,dp[row][col]);
        return dp[row][col];
    }

    public static void main(String []args){
        LongestIncreasingPath li=new LongestIncreasingPath();
        int [][]input={
                {3,4,5},
                {3,2,6},
                {2,2,1}
        };
        System.out.println(li.longestIncreasingPath(input));
    }
}

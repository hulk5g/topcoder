package DFS;

/**
 * @author ksharma
 */
public class MaxAreaOfIsland {
    int []row={1,-1,0,0};
    int []col={0,0,1,-1};
    public int maxAreaOfIsland(int[][] grid) {
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] !=0 && grid[i][j]!=-1){
                    int temp=dfs(grid, i, j);
                    count=Math.max(count,temp);
                }
            }
        }
        return count;
    }

    public int dfs(int[][]grid, int r, int c){
        grid[r][c]=-1;
        int count=1;
        for(int i=0;i<row.length;i++){
            int xx=r+row[i];
            int yy=c+col[i];
            if(xx>=0 && xx< grid.length && yy>=0 && yy< grid[0].length && grid[xx][yy]!=0 && grid[xx][yy]!=-1){
                count+=dfs(grid,xx,yy);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        MaxAreaOfIsland ma=new MaxAreaOfIsland();
        int [][]grid={{0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}};
        System.out.println(ma.maxAreaOfIsland(grid));
    }

}

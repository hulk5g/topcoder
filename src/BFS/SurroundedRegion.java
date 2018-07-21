package BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ksharma
 */
public class SurroundedRegion {
    public void solve(char[][] board) {
        int []row={0,0,1,-1};
        int []col={1,-1,0,0};
        int m=board.length;
        int n=board[0].length;
        Queue<int[]>q=new LinkedList<>();
        for(int i=0;i<m;i++){
            if(board[i][0]=='O'){
                board[i][0]='p';
                q.offer(new int[]{i,0});
            }
            if(board[i][n-1]=='O'){
                board[i][n-1]='p';
                q.offer(new int[]{i,n-1});
            }
        }

        for(int j=0;j<n;j++){
            if(board[0][j]=='O'){
                board[0][j]='p';
                q.offer(new int[]{0,j});
            }
            if(board[m-1][j]=='O'){
                board[m-1][j]='p';
                q.offer(new int[]{m-1,j});
            }
        }

        while(!q.isEmpty()){
            int []temp=q.poll();
            for(int k=0;k<4;k++){
                int x=temp[0]+row[k];
                int y=temp[1]+col[k];
                if(x>=0 && x<m && y>=0 && y<n && board[x][y]=='O'){
                    board[x][y]='p';
                    q.offer(new int[]{x,y});
                }
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='p'){
                    board[i][j]='O';
                }
            }
        }

    }

    public static void main(String []args){
        char[][] input={{'X','X','X','X'},
                {'X','O','O','X'},
                {'X','X','O','X'},
                {'X','O','X','X'}};
        SurroundedRegion sr=new SurroundedRegion();
        sr.solve(input);
        for(int i=0;i<input.length;i++){
            for(int j=0;j<input[0].length;j++){
                System.out.print(input[i][j]+",");
            }
            System.out.println();
        }
    }
}

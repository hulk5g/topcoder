package Array;

import java.util.Calendar;

/**
 * @author ksharma
 */
public class GameOfLife {
    int []r={-1,-1,-1,1,1,1,0,0};
    int []c={-1,0,1,-1,0,1,-1,1};

    public void gameOfLife(int[][] board) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                int liveCount=getLiveCount(board,i,j);
                if(board[i][j]==1 && (liveCount==2||liveCount==3)){
                    //set the second bit. Dont change the first bit which is current state
                        board[i][j]=3;
                }else if(board[i][j]==0 && liveCount==3){
                    //set the second bit.  Dont change the first bit which is current state
                        board[i][j]=2;

                }
            }
        }
        for(int i=0;i<board.length;i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j]=board[i][j]>>1;
            }
        }
    }

    private int getLiveCount(int [][]board,int i,int j){
        int liveCount=0;
        for(int k=0;k<8;k++){
            int xx=i+r[k];
            int yy=j+c[k];
            if(xx>=0 && xx<board.length && yy >=0 && yy < board[0].length){
                if((board[xx][yy]&1) ==1)liveCount++;
            }
        }
        return liveCount;
    }

    public static void main(String []args){
        GameOfLife gl=new GameOfLife();
        int [][] input= {{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        /*gl.gameOfLife(input);
        for(int i=0;i<input.length;i++){
            for(int j=0;j<input[0].length;j++){
                System.out.print(input[i][j]+" ");
            }
            System.out.println();
        }*/
        Calendar cal=Calendar.getInstance();
        System.out.println(cal.get(Calendar.SECOND)+":"+cal.get(Calendar.MILLISECOND));

    }
}

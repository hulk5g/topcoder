package Backtracking;

/**
 * @author ksharma
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        boolean [][]visited=new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(helper(board, word,i,j,0,visited)){
                    return true;
                }
            }
        }
        return false;
    }

    boolean helper(char[][] board, String word,int row, int col,int idx,boolean[][]visited){
        if(idx>=word.length()){
            return true;
        }
        if(row>=0 && row<board.length && col >=0 && col<board[0].length && visited[row][col]==false &&
        board[row][col]==word.charAt(idx)){
            visited[row][col]=true;
            if(helper(board,word,row+1,col,idx+1,visited) ||
                    helper(board,word,row-1,col,idx+1,visited) ||
                    helper(board,word,row,col+1,idx+1,visited) ||
                    helper(board,word,row,col-1,idx+1,visited)){
                return true;
            }
            visited[row][col]=false;
        }
        return false;
    }

    public static void main(String []args){
        WordSearch ws=new WordSearch();
        char [][]board= {{'A'}};
        System.out.println(ws.exist(board,"A"));

    }
}

package BFS;

import javafx.util.Pair;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author ksharma
 */
public class SlidingPuzzle {
    public int slidingPuzzle(int[][] board) {
        int []rowAdj={1,-1,0,0};
        int []colAdj={0,0,1,-1};
        int count=0;
        Queue<Pair<Integer,Integer>> q=new LinkedList<>();
        Set<Integer>seen=new HashSet<>();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==0){
                    q.offer(new Pair<>(i,j));
                    break;
                }
            }
        }

        while(!q.isEmpty()){
            Pair<Integer,Integer> zeroPair=q.poll();
            if(!isSolved(board)){
                for(int i=0;i<4;i++){
                    int adjX=zeroPair.getKey()+rowAdj[i];
                    int adjY=zeroPair.getValue()+colAdj[i];
                    if(adjX>=0 && adjX<2 && adjY>=0 && adjY<3 && !seen.contains(board[adjX][adjY])){
                        int temp=board[adjX][adjY];
                        board[zeroPair.getKey()][zeroPair.getValue()]=board[adjX][adjY];
                        board[adjX][adjY]=temp;
                        q.offer(new Pair<>(adjX,adjY));
                        count++;
                        seen.add(board[adjX][adjY]);
                        break;
                    }
                }
            }
        }
    return count;
    }

    private boolean isSolved(int [][]input){
        int [][]sol={{1,2,3},{4,5,0}};
        for(int i=0;i<sol.length;i++){
            for(int j=0;j<sol[0].length;j++){
                if(sol[i][j]!=input[i][j]){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String []args){
        int [][] input={{4,1,2},{5,0,3}};
        SlidingPuzzle sp=new SlidingPuzzle();
        System.out.println(sp.slidingPuzzle(input));
    }
}

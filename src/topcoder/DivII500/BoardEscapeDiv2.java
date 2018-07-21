package topcoder.DivII500;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ksharma
 */
public class BoardEscapeDiv2 {

    int []row={1,-1,0,0};
    int []col={0,0,1,-1};
    class Pos{
        int x;
        int y;
        int val;
        public Pos(int x,int y,int val){
            this.x=x;
            this.y=y;
            this.val=val;
        }
    }

    public 	String findWinner(String[] s, int k){
        int n=s.length;
        int m=s[0].length();
        char[][]graph=new char[n][m];
        Pos start=null;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                graph[i][j]=s[i].charAt(j);
                if(graph[i][j]=='T'){
                    start=new Pos(i,j,k);
                }
            }
        }
        int turn=0;
        int winner=-1;
        Queue<Pos> Q=new LinkedList<>();
        Q.offer(start);
        boolean moved=false;
        while(!Q.isEmpty()){
            moved=false;
            int sz=Q.size();
            for(int i=0;i<sz;i++){
                Pos curr=Q.poll();
                if(graph[curr.x][curr.y]=='E' || curr.val==0){
                    winner=changeTurn(turn);
                    break;
                }
                for(int j=0;j<row.length;j++){
                    int xx=curr.x+row[j];
                    int yy=curr.y+col[j];
                    if(xx>=0 && xx<n && yy>=0 && yy<m && graph[xx][yy]!='#'){
                        Q.offer(new Pos(xx,yy,curr.val-1));
                        moved=true;
                    }
                }
            }
            turn=changeTurn(turn);
            if(!moved){
                winner=turn;
                break;
            }

        }
        return winner==0?"Alice":"Bob";
    }

    public int changeTurn(int turn){
        if(turn==0)return 1;
        return 0;
    }
    public static void main(String[] args) {
        BoardEscapeDiv2 be=new BoardEscapeDiv2();
        System.out.println(be.findWinner(new String[]{"#E...",
                "#...E",
                "E.T#.",
                "..#.."},13));
    }
}

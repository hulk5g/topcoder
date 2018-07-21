package DFS;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ksharma
 */
public class MazeIII {
    String dir="impossible";
    int maxLen=Integer.MAX_VALUE;
    int []row={1,-1,0,0};
    int []col={0,0,-1,1};
    char[]dirs={'d','u','l','r'};

    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        Map<Character,int[]>dirMap=new HashMap<>();
        dirMap.put('d',new int[]{1,0});
        dirMap.put('u',new int[]{-1,0});
        dirMap.put('l',new int[]{0,-1});
        dirMap.put('r',new int[]{0,1});
        boolean [][]visited=new boolean[maze.length][maze[0].length];
        helper(maze,hole,new StringBuilder(),ball[0],ball[1],0,dirMap,null,visited);
        return dir;
    }

    private void helper(int[][] maze, int[] hole, StringBuilder sb, int br, int bc, int tempLen, Map<Character,
            int[]>dirMap,Character prevDir,boolean [][]visited) {
        if(tempLen>maxLen) return;
        if(br==hole[0] && bc==hole[1]){
            if(tempLen<maxLen){
                maxLen=tempLen;
                dir=sb.toString();
                return;
            }else if(tempLen==maxLen){
                String tempDir=sb.toString();
                dir=tempDir.compareTo(dir)<0?tempDir:dir;
                return;
            }else{
                return;
            }
        }
        visited[br][bc]=true;
        if(prevDir==null){
            for(int k=0;k<row.length;k++){
                int xx=br+row[k];
                int yy=bc+col[k];
                if(xx>=0 && xx<maze.length && yy >=0 && yy <maze[0].length && maze[xx][yy]!=1 && !visited[xx][yy]){
                    int len=sb.length();
                    if(len==0 || sb.charAt(sb.length()-1)!=dirs[k]){
                        sb.append(dirs[k]);
                    }
                    helper(maze,hole,sb,xx,yy,tempLen+1,dirMap,dirs[k],visited);
                    sb.setLength(len);
                }
            }
        }else{
            int xx=br+dirMap.get(prevDir)[0];
            int yy=bc+dirMap.get(prevDir)[1];
            if(xx>=0 && xx<maze.length && yy >=0 && yy <maze[0].length && maze[xx][yy]!=1 && !visited[xx][yy]){
                helper(maze,hole,sb,xx,yy,tempLen+1,dirMap,prevDir,visited);
            }else{
                helper(maze,hole,sb,br,bc,tempLen,dirMap,null,visited);
            }
        }
        visited[br][bc]=false;
    }

    public static void main(String[] args) {
        MazeIII maze = new MazeIII();
        int[][] m = {{0,0,0,0,0,0,0},{0,0,1,0,0,1,0},{0,0,0,0,1,0,0},{0,0,0,0,0,0,1}};
        int[] ball = {0, 4};
        int[] hole = {3, 5};
        System.out.println(maze.findShortestWay(m, ball, hole));
    }
}

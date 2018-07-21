package Array;

/**
 * @author ksharma
 */
public class SquirrelSimulation {
    public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
        int maxDiff=Integer.MIN_VALUE;
        int total=0;
        for(int i=0;i<nuts.length;i++){
            int diff=Math.abs(nuts[i][0]-tree[0]) + Math.abs(nuts[i][1]-tree[1]);
            int sqToNut=Math.abs(squirrel[0]-nuts[i][0]) + Math.abs(squirrel[1]-nuts[i][1]);
            total+=2*diff;
            maxDiff=Math.max(maxDiff,diff-sqToNut);
        }
        return total-maxDiff;
    }

    public static void main(String []args){
        SquirrelSimulation ss=new SquirrelSimulation();
        int [][]nuts={{3,0},{2,5}};
        System.out.println(ss.minDistance(5,7,new int[]{2,2},new int[]{4,4},nuts));

    }
}

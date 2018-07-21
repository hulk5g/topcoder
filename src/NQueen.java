/**
 * @author ksharma
 */
public class NQueen {

    public boolean solveUtil(int[][]sol,int col){
        if(col>=sol.length){
            printBorad(sol);
            return true;
        }

        for(int row=0;row<sol.length;row++){
            if(isSafe(sol,row,col)){
                sol[row][col]=1;
                solveUtil(sol,col+1);
                /*if(solveUtil(sol,col+1)){
                    return true;
                }*/
                sol[row][col]=0;
            }
        }
        return false;
    }

    private boolean isSafe(int[][] sol, int row, int col) {
        for(int i=0;i<col;i++){
            if(sol[row][i]==1)
                return false;
        }
        for(int i=row,j=col;i>=0 && j>=0;i--,j--){
            if(sol[i][j]==1)
                return false;
        }

        for(int i=row,j=col;i<sol.length &&j>=0;i++,j--){
            if(sol[i][j]==1)
                return false;
        }
        return true;
    }

    public void solve(int n){
        int sol[][]=new int[n][n];
        initialize(sol);
        if(!solveUtil(sol,0)){
            System.out.println("no solution exists");
        }else{
            printBorad(sol);
        }
    }

    private void printBorad(int[][] sol) {
        for(int i=0;i<sol.length;i++){
            for(int j=0;j<sol[0].length;j++){
                System.out.print(sol[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }

    private void initialize(int[][] sol) {
        for(int i=0;i<sol.length;i++){
            for(int j=0;j<sol[0].length;j++){
                sol[i][j]=0;
            }
        }
    }

    public static void main(String []args){
        NQueen queen=new NQueen();
        queen.solve(4);
    }
}

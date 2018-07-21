package Array;

/**
 * @author ksharma
 */
public class MAtrdixReshape {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int m=nums.length;
        int n=nums[0].length;
        if((m*n) < (r*c)) return nums;
        int [][]A=new int[r][c];
        int row=0,col=0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                A[i][j]=nums[row][col];
                col++;
                if(col==n){
                    row++;
                    col=0;
                }
            }
        }
        return A;
    }

    public static void main(String[] args) {
        MAtrdixReshape mr=new MAtrdixReshape();
        int [][]p={{1,2},
                {3,4}};
        System.out.println(mr.matrixReshape(p,1,4));
    }
}

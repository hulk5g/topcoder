// Java program to count islands in boolean 2D matrix
class Islands
{

    int []row={-1,-1,-1,0,1,1,1,0};
    int []col={-1,0,1,1,1,0,-1,-1};
    int count=0;
    int longestCount=0;
    String longestPath="";

    int countIslands(int [][]M){
        for(int i=0;i<M.length;i++){
            for(int j=0;j<M[0].length;j++){
                if(M[i][j]==1){
                  //  M[i][j]=-1;
                    count++;
                    DFSUtil(i,j,M,0,longestPath);
                }
            }
        }
        return count;
    }

    private void DFSUtil(int i, int j, int[][] m,int maxLength, String maxPath) {
        maxLength++;
        m[i][j]=-1;
        maxPath+=i+"-"+j+",";
        for(int k=0;k<8;k++){
            int rowN=i+row[k];
            int colN=j+col[k];
            if(0<=rowN && rowN<m.length && 0<=colN && colN<m[0].length ) {
                if (m[rowN][colN] == 1) {
                    DFSUtil(rowN, colN, m,maxLength,maxPath);

                }
            }
            if(longestCount<maxLength){
                longestCount=maxLength;
                longestPath=maxPath;
            }
        }
    }

    // Driver method
    public static void main (String[] args) throws java.lang.Exception
    {
        int M[][]=  new int[][] {{1, 1, 0, 0, 0},
                                 {0, 1, 0, 0, 1},
                                 {1, 0, 0, 1, 1},
                                 {0, 0, 0, 0, 0},
                                 {1, 0, 1, 0, 1}
        };
        Islands I = new Islands();
        System.out.println( "no of island="+I.countIslands(M));
        System.out.println( "max length island="+I.longestCount);
        System.out.println( "longest path island="+I.longestPath);
    }
}


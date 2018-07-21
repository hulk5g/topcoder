package topcoder.DivII500;

/**
 * @author ksharma
 */
public class CubeStackingGame {
    public int MaximumValue(int n, int[] c1, int[] c2, int[] c3, int[] c4){
        int count=1;
        if(n==1)return count;
        boolean includedPrev=false;
        for(int i=1;i<n;i++){
            int j=0;
            while(j<3){
                if(c1[i-1]!=c1[i] && c2[i-1]!=c2[i] && c3[i-1]!=c3[i] && c4[i-1]!=c4[i]){
                    count++;
                    includedPrev=true;
                    break;
                }
                rotate(c1,c2,c3,c4,i);
                j++;
            }
            if(!includedPrev)break;

        }
        return count;
    }

    private void rotate(int[] c1, int[] c2, int[] c3, int[] c4, int i) {
        int temp=c1[i];
        c1[i]=c2[i];
        c2[i]=c3[i];
        c3[i]=c4[i];
        c4[i]=temp;
    }

    public static void main(String[] args) {
        CubeStackingGame cs=new CubeStackingGame();
        System.out.println(cs.MaximumValue(4,
       new int[] {1,1,1,1},
       new int[] {2,2,2,4}, new int[]{3,3,3,3},
       new int[] {4,4,4,2}

        ));
    }
}

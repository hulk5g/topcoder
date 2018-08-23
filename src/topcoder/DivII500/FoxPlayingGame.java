package topcoder.DivII500;

/**
 * @author ksharma
 */
public class FoxPlayingGame {

    public double theMax(int nA, int nB, int paramA, int paramB){
        double [][]memo=new double[nA+1][nB+1];
        return helper(nA,nB,paramA/1000.0,paramB/1000.0,0.0,memo);
    }

    public double helper(int nA, int nB, double scoreA, double scoreB,double sum,double [][]memo){

        if(nA==0 && nB==0){
            return sum;
        }else if(nA==0){
            for(int i=0;i<nB;i++){
                sum*=scoreB;
            }
            return sum;
        }else if(nB==0){
            for(int i=0;i<nA;i++){
                sum+=scoreA;
            }
            return sum;
        }
        if(memo[nA][nB]>0)return memo[nA][nB];
        return memo[nA][nB]=Math.max(helper(nA-1,nB,scoreA,scoreB,sum+scoreA,memo),
                helper(nA,nB-1,scoreA,scoreB,sum*scoreB,memo));
    }

    public static void main(String[] args) {
        FoxPlayingGame fp=new FoxPlayingGame();
        System.out.println(fp.theMax(38, 43, -6852, 482


        ));
    }
}

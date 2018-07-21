package DP;

/**
 * @author ksharma
 */
public class LargestSumOfAverage {
    public double largestSumOfAverages(int[] A, int K) {
        return dp1DArray(A,K);
    }

    private double dp1DArray(int [] A,int K){
        int n=A.length;
        double []dp=new double[n];
        double []p=new double[n];
        p[0]=A[0];
        for(int i=1;i<n;i++){
            p[i]=p[i-1]+A[i];
        }
        for(int i=0;i<n;i++){
            dp[i]=p[i]/(i+1);
        }

        for(int k=2;k<=K;k++){
            for(int i=0;i<n;i++){
                    for(int j=0;j<i;j++){
                        dp[i]=Math.max(dp[i],dp[j]+(p[i]-p[j])/(i-j));
                    }
            }
        }
        return dp[n-1];
    }
    private double dp2DArray(int [] A,int K){
        int n=A.length;
        double [][]dp=new double[n][K+1];
        double []p=new double[n];
        p[0]=A[0];
        for(int i=1;i<n;i++){
            p[i]=p[i-1]+A[i];
        }

        for(int k=1;k<=K;k++){
            for(int i=0;i<n;i++){
                if(k==1){
                    dp[i][k]=p[i]/(i+1);
                }else if(k>i+1){
                    dp[i][k]=-1d;
                }else{
                    for(int j=0;j<i;j++){
                        dp[i][k]=Math.max(dp[i][k],dp[j][k-1]+(p[i]-p[j])/(i-j));
                    }
                }
            }
        }
        return dp[n-1][K];
    }

    public static void main(String []args){
        int [] A = {9,1,2,3,9};
        int K = 3;
        LargestSumOfAverage ls=new LargestSumOfAverage();
        System.out.println(ls.largestSumOfAverages(A,K));
    }
}

package topcoder.DivII500;

/**
 * @author ksharma
 */
public class Haar1D {
    public int[] transform(int[] data, int L){
        int []A=data;
        int n=A.length;
       for(int i=0;i<L;i++){
           int []B= helper(A,0,n);
           if(i==0){
               A=B;
           }else{
               for(int j=0;j<n;j++){
                   A[j]=B[j];
               }
           }
           n=n/2;
       }
       return A;
    }

    public int[] helper(int []data, int lo,int hi){
        int n=hi-lo;
        int []B=new int[n];
        int j=0;
        for(int i=lo;i<n;i=i+2){
            int sum=data[i]+data[i+1];
            int diff=data[i]-data[i+1];
            B[j]=sum;
            B[j+n/2]=diff;
            j++;
        }
        return B;
    }

    public static void main(String[] args) {
        Haar1D h=new Haar1D();
        System.out.println(h.transform(new int[]{1, 2, 3, 4, 4, 3, 2, 1},3));
    }
}

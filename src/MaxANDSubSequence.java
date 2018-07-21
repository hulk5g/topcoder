/**
 * Created by ksharma on 4/28/17.
 */
public class MaxANDSubSequence {


    static void subSeq(long arr[], int n, int r, int index,
                                long data[], int i,long[]result)
    {

        if (index == r)
        {
            long res=-1;
            for (int j=0; j<r; j++){
                if(res<0){
                    res=data[j];
                }else{
                    res=res&data[j];
                }
            }

            if(res>result[0]){
                result[0]=res;
                result[1]=1;
            }else if(res==result[0]){
                result[1]++;
            }
            return;
        }

        if (i >= n)
            return;


        data[index] = arr[i];
        subSeq(arr, n, r, index + 1, data, i + 1, result);
        subSeq(arr, n, r, index, data, i + 1, result);
    }


    static long[] solve(int n, int k, long[] a){
        long data[]=new long[k];
        long[]result=new long[2];
        result[0]=0;
        result[1]=0;
        subSeq(a, n, k, 0, data, 0, result);
        result[1]= (long) (result[1]%(Math.pow(10,9)+7));
        return result;
    }

    public static void main(String[] args) {
       /* Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        long[] a = new long[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextLong();
        }
        long[] result = solve(n, k, a);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != n - 1 ? "\n" : ""));
        }
        System.out.println("");*/
        double i=Math.pow(2,7)*Math.pow(2,8)*Math.pow(2,9);

        System.out.println((Math.pow(2,7)*Math.pow(2,8)*Math.pow(2,9)));
    }
}

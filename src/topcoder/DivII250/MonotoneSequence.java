package topcoder.DivII250;

/**
 * @author ksharma
 */
public class MonotoneSequence {
    public int  longestMonotoneSequence(int[] seq){

        int count=1;
        int prev=seq[0];
        int max=1;
        for(int i=1;i<seq.length;i++){
            if(seq[i] > prev){
                count++;
                max=Math.max(max,count);
            }else{
                count=1;
            }
            prev=seq[i];
        }
        count=1;
        prev=seq[0];
        for(int i=1;i<seq.length;i++){
            if(seq[i] < prev){
                count++;
                max=Math.max(max,count);
            }else{
                count=1;
            }
            prev=seq[i];
        }
        return max;
    }

    public static void main(String[] args) {
        MonotoneSequence ms=new MonotoneSequence();
        System.out.println(ms.longestMonotoneSequence(new int[]{1, 7, 7, 8, 3, 6, 7, 2}));
    }

}

package topcoder.DivII250;

/**
 * @author ksharma
 */
public class DNASequence {
    public int longestDNASequence(String sequence){
        char [] arr=sequence.toCharArray();
        int max=Integer.MIN_VALUE;
        int temp=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]=='A' || arr[i]=='C'||arr[i]=='G'||arr[i]=='T'){
                temp++;
                max=Math.max(max,temp);
            }else{
                temp=0;
            }
        }
        return max;
    }

    public static void main(String []args){
        DNASequence ds=new DNASequence();
        System.out.println(ds.longestDNASequence("VVZWKCSIQEGANULDLZESHUYHUQGRKUMFCGTATGOHMLKBIRCA"));
    }
}

package Strings;

/**
 * @author ksharma
 */
public class DecodeWays {
    public int numDecodings(String s) {
        return helper(s);
    }

    public int helper(String s){
        if(s.length()==1){
            return 1;
        }
        int total=0;
        for(int i =0;i<s.length();i++){
            String s1=s.substring(0,i);
            String s2=s.substring(i+1);
            int n1=helper(s1);
            int n2=helper(s2);
            total+=n1*n2;
        }
        return total;
    }

    public static void main(String []args){
        DecodeWays dw=new DecodeWays();
        System.out.println(dw.numDecodings("226"));
    }
}

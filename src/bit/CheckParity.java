package bit;

/**
 * @author ksharma
 */
public class CheckParity {

    public int parity(int n){
        int result=0;
        while(n>0){
            result=result^1;
            n=n&(n-1);
        }
        return result;
    }
    public static void main(String []args){
        CheckParity cp=new CheckParity();
        System.out.println(cp.parity(22));
    }
}

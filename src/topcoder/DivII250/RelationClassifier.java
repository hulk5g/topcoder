package topcoder.DivII250;

/**
 * @author ksharma
 */
public class RelationClassifier {
    public String isBijection(int[] domain, int[] range){
        int [] A=new int[100];
        int [] B=new int[100];
        for(int i=0;i<domain.length;i++){
            A[domain[i]]++;
            B[range[i]]++;
            if(A[domain[i]]>1 || B[domain[i]]>1){
                return "Not";
            }
        }
        return "Bijection";
    }

    public static void main(String []args){

    }
}

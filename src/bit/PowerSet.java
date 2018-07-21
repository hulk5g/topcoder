package bit;

/**
 * @author ksharma
 */
public class PowerSet {

    public void printPowerSet(int []a){
        int n=a.length;
        boolean first;
        for(int i=0;i<(1<<n);i++){
            first=false;
            for(int j=0;j<32;j++){
                if((i&(1<<j))> 0){
                    if(first){
                        System.out.print(",");
                    }else{
                        first=true;
                    }
                    System.out.print(a[j]);
                }

            }
            System.out.println();
        }
    }
    public static void main(String []args){
        PowerSet ps=new PowerSet();
        int []a={1,3,4,2};
        ps.printPowerSet(a);
    }
}

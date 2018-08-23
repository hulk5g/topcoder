package topcoder.DivII500;

/**
 * @author ksharma
 */
public class FixedDiceGameDiv2 {

    public double getExpectation(int a, int b){
        double sum =0;
        int count=0;
        for(int i=2;i<=a;i++){
            for(int j=1;j<=b && j<i;j++){
                sum+=i;
                count++;
            }
        }
        return sum/count;
    }

    public static void main(String[] args) {
        FixedDiceGameDiv2 fd=new FixedDiceGameDiv2();
        System.out.println(fd.getExpectation(11,
                13
        ));
    }
}

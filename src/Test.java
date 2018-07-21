/**
 * Created by ksharma on 5/2/17.
 */
public class Test {

    public void helper(Tie t){
        t.setVal(4);
    }
    public static void main(String[] args) {
        Test test=new Test();
        Tie t=new Tie();
        test.helper(t);
        System.out.println(t.getVal());
    }
}

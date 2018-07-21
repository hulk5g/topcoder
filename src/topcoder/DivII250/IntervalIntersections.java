package topcoder.DivII250;

/**
 * @author ksharma
 */
public class IntervalIntersections {

    public  int minLength(int x1, int y1, int x2, int y2){
        if(x2<x1){
           return minLength(x2, y2, x1, y1);
        }
        if(x1<=x2 && x2<y1)return 0;
        return Math.abs(y1-x2);
    }
    public static void main(String []args){
        IntervalIntersections  i=new IntervalIntersections();
        System.out.println(i.minLength(1,1,1000000,1000000));
    }
}

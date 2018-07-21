package topcoder.DivII250;

/**
 * @author ksharma
 */
public class MakingPairs {
    public int get(int[] card){
        int count=0;
        for(int i:card){
            count+=i/2;
        }
        return count;
    }

    public static void main(String []args){
        MakingPairs mp=new MakingPairs();
        System.out.println(mp.get(new int []{43,23,10,39,39,22,22,0,3,4,3,2}));
    }
}

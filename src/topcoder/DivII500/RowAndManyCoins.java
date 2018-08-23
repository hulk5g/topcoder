package topcoder.DivII500;

/**
 * @author ksharma
 */
public class RowAndManyCoins {

    public String getWinner(String cells){
        int n = cells.length();
        if ( cells.charAt(0) == 'A' || cells.charAt(n-1) == 'A' ){
            return "Alice";
        } else {
            return "Bob";
        }
    }

    public static void main(String[] args) {
        RowAndManyCoins rw=new RowAndManyCoins();
        System.out.println(rw.getWinner("BBBAAABBAAABBB"));
    }
}

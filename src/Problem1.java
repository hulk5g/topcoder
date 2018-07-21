import java.util.Scanner;

/**
 * Created by ksharma on 4/28/17.
 */
public class Problem1 {
    static final int MAX_POINT=100;
    static final int PER_SWIPE_POINT=10;
    static int getPoints(int month1, int month2, int month3){
        int month1Points= month1*PER_SWIPE_POINT;
        month1Points=month1Points>MAX_POINT?MAX_POINT:month1Points;
        int month2Points= month2*PER_SWIPE_POINT;
        month2Points=month2Points>MAX_POINT?MAX_POINT:month2Points;
        int month3Points= month3*PER_SWIPE_POINT;
        month3Points=month3Points>MAX_POINT?MAX_POINT:month3Points;
        return month1Points+month2Points+month3Points;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int month1 = in.nextInt();
        int month2 = in.nextInt();
        int month3 = in.nextInt();
        int pointsEarned = getPoints(month1, month2, month3);
        System.out.println(pointsEarned);
    }
}

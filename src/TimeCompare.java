import java.util.Scanner;

/**
 * Created by ksharma on 5/5/17.
 */
public class TimeCompare {
    static String timeCompare(String t1, String t2){
       if(t1.contains("AM") && t2.contains("PM"))
           return "First";
        else if(t1.contains("PM") && t2.contains("AM"))
           return "Second";
        String t1Hour=t1.substring(0,2);
        String t2Hour=t2.substring(0,2);
        if(t1Hour.equals("12")){
            t1Hour="0";
        }
        if(t2Hour.equals("12")){
            t2Hour="0";
        }
        if((Integer.parseInt(t1Hour) < Integer.parseInt(t2Hour)))
            return "First";
        if((Integer.parseInt(t1Hour) > Integer.parseInt(t2Hour)))
            return "Second";
        String t1Min=t1.substring(3,5);
        String t2Min=t2.substring(3,5);
        if((Integer.parseInt(t1Min) < Integer.parseInt(t2Min)))
            return "First";
        if((Integer.parseInt(t1Min) > Integer.parseInt(t2Min)))
            return "Second";
        return null;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String t1 = in.next();
            String t2 = in.next();
            String result = timeCompare(t1, t2);
            System.out.println(result);
        }
    }
}

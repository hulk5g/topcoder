package topcoder.DivII250;

/**
 * @author ksharma
 */
public class MakeTwoConsecutive {
    boolean isBeautiful(String s){
        if(s.isEmpty())return false;
        char prev=s.charAt(0);
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==prev){
                return true;
            }
            prev=s.charAt(i);
        }
        return false;
    }
    String solve(String S){
        for(int i=0;i< S.length();i++){
            String s=S.substring(0,i)+S.substring(i+1);
            if(isBeautiful(s))return "Possible";
        }
        return "Impossible";
    }

    public static void main(String []args){
        MakeTwoConsecutive mm=new MakeTwoConsecutive();
        System.out.println(mm.solve("VIKING"));
    }
}

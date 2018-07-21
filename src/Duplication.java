import java.util.Scanner;

public class Duplication {

    static  StringBuilder resultString=null;
    static StringBuilder flip(StringBuilder t){
        StringBuilder s=new StringBuilder(t);
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='0'){
                s.setCharAt(i,'1');
            }else{
                s.setCharAt(i,'0');
            }
        }
        return s;
    }
    static String duplication(int x){
        if(resultString==null) {
            StringBuilder s = new StringBuilder("0");
            int j = 0;
            while (j < 10) {
                StringBuilder flipped = flip(s);
                s = s.append(flipped);
                j++;
            }
            resultString=s;
        }
        return String.valueOf(resultString.charAt(x));
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int x = in.nextInt();
            String result = duplication(x);
            System.out.println(result);
        }

    }
}
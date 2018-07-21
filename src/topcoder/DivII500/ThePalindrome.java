package topcoder.DivII500;

/**
 * @author ksharma
 */
public class ThePalindrome {
    public int find(String s){
        StringBuilder sb1=new StringBuilder(s);
        if(sb1.toString().equals(sb1.reverse().toString())) return s.length();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            sb.append(c);
            String s2=sb1.toString()+sb.reverse().toString();
            StringBuilder sb2=new StringBuilder(s2);
            if(sb2.toString().equals(sb2.reverse().toString())) return sb2.length();
        }
        return s.length();
    }

    public static void main(String[] args) {
        ThePalindrome tp=new ThePalindrome();
        System.out.println(tp.find("abab"));
    }
}

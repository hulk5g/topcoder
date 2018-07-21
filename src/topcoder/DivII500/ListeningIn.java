package topcoder.DivII500;

/**
 * @author ksharma
 */
public class ListeningIn {
    public String probableMatch(String typed, String phrase){
        int i=0,j=0;
        StringBuilder sb=new StringBuilder();
        while(i<typed.length() && j<phrase.length()){
            if(typed.charAt(i)==phrase.charAt(j)){
                i++;j++;
            }else{
                sb.append(phrase.charAt(j));
                j++;
            }
        }
        if(i==typed.length()){
            sb.append(phrase.substring(j));
            return sb.toString();
        }
        return "UNMATCHED";
    }

    public static void main(String[] args) {
        ListeningIn li=new ListeningIn();
        System.out.println(li.probableMatch("back  to base","back to base"));
    }
}

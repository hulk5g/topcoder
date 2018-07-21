import java.util.HashSet;
import java.util.Set;

/**
 * @author ksharma
 */
public class TogglePermutation {
    static int p=0;

    public Set<String> toggle(String s){
        p++;
        if(s==null) return null;
        Set<String>result=new HashSet<>();
        if(s.length()==1){
            result.add(s);
            result.add(toggleCase(s));
            return result;
        }
        String c =s.substring(0,1);
        Set<String> tempSet=toggle(s.substring(1));
        int count=0;
        while(count<2){
            for(String t:tempSet){
                p++;
                result.add(c+t);
            }
            count++;
            c=toggleCase(c);
        }
        return result;
    }

    private String toggleCase(String s) {
        char c=s.charAt(0);
        if(Character.isLowerCase(c)){
            return String.valueOf(Character.toUpperCase(c));
        }
        return String.valueOf(Character.toLowerCase(c));
    }

    public static void main(String []args){
        String s="abc";
        TogglePermutation tp=new TogglePermutation();
        //Set<String>result=tp.toggle(s);
       // System.out.println(result);
        //System.out.println(p);
        String []s1=s.split("");
        System.out.println(s1);
    }
}

import java.util.HashSet;
import java.util.Set;

/**
 * @author ksharma
 */
public class Permutation {


    public Set<String> perm(String s){

        Set<String> result=new HashSet<>();
        if(s==null) return null;
        if(s.length()==1){
            result.add(s);
            return result;
        }
        char s1=s.charAt(0);
        String s2=s.substring(1);
        if(s2.length()>0){
            Set<String> tempSet=new HashSet<>();
            tempSet=perm(s2);
            for(String temp:tempSet){
                for(int i=0;i<=temp.length();i++){
                    String sb=temp.substring(0,i)+s1+temp.substring(i);
                    result.add(sb);
                }
            }
        }
        return result;

    }

    public static void main(String []args){
        Permutation p=new Permutation();
        String s="abc";
        Set<String>result=p.perm(s);
        System.out.println(result.size());
    }
}

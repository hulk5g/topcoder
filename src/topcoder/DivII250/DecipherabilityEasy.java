package topcoder.DivII250;

/**
 * @author ksharma
 */
public class DecipherabilityEasy {
   public  String check(String s, String t){
       boolean [] arr=new boolean[26];
       for(int i=0;i<s.length();i++){
           arr[s.charAt(i)-'a']=true;
       }
       int count=0;
       for(int i=0;i<t.length();i++){
           if(!arr[t.charAt(i)-'a']){
               count++;
           }
           if(count>1)return "Impossible";
       }
       return "Possible";
   }
}

package Backtracking;

/**
 * @author ksharma
 */
public class WildCardMatching {
    public boolean isMatch(String s, String p) {

        return sol1(s,p,0,0);
    }

    public boolean sol1(String s,String p,int sIdx, int pIdx){
        if(pIdx==p.length())return sIdx==s.length();

        if(sIdx<s.length() && (s.charAt(sIdx)==p.charAt(pIdx) || p.charAt(pIdx)=='?')){
            return sol1(s,p,sIdx+1,pIdx+1);
        }else if(p.charAt(pIdx)=='*'){
            while(pIdx<p.length() && p.charAt(pIdx)=='*'){
                pIdx++;
            }
            while(sIdx<s.length()){
                if(sol1(s,p,sIdx,pIdx))return true;
                sIdx++;
            }
            return sol1(s,p,sIdx,pIdx);
        }
        return false;
    }



    public static void main(String []args){
        WildCardMatching wc=new WildCardMatching();
        String s = "acdcb";
        String p = "a*c?b";
        System.out.println(wc.isMatch(s,p));
    }
}

package Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ksharma
 */
public class RestoreIpAddress {
    public List<String> restoreIpAddresses(String s) {
        List<String> result=new ArrayList<>();
        StringBuilder sb=new StringBuilder(s);
        helper(result,sb,1,s);
        return result;
    }

    private void helper(List<String> result, StringBuilder sb, int idx,String s) {
        if(sb.length()==s.length()+3){
            if(isValid(sb)){
                result.add(sb.toString());
            }
            return;
        }
        for(int i=idx;i<sb.length();i++){
            sb.insert(i,'.');
            helper(result,sb,i+1,s);
            sb.deleteCharAt(i);
        }
    }

    private boolean isValid(StringBuilder sb) {
        String[]ips=sb.toString().split("\\.");
        if(ips.length!=4)return false;
        for(String s:ips){
            if(s.length()==0 ||s.length()>3 || Integer.parseInt(s)>255 ||(s.length()>1 && s.startsWith("0"))) return
                    false;
        }
        return true;
    }

    public static void main(String []args){
        RestoreIpAddress ip=new RestoreIpAddress();
        System.out.println(ip.restoreIpAddresses("25525511135"));
    }
}

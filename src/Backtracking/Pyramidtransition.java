package Backtracking;

import java.util.*;

/**
 * @author ksharma
 */
public class Pyramidtransition {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        Map<String,List<Character>>map=new HashMap<>();
        for(String s:allowed){
            String s1=s.substring(0,2);
            map.putIfAbsent(s1,new ArrayList<>());
            map.get(s1).add(s.charAt(2));
        }
        return helper(bottom,0,new StringBuilder(),map);
    }

    private boolean helper(String bottom, int idx, StringBuilder sb, Map<String,List<Character>>map) {
        if(bottom.length()==1)return true;
        if(sb.length()==bottom.length()-1){
            return helper(sb.toString(),0,new StringBuilder(),map);
        }
            String s1=bottom.substring(idx,idx+2);
            if(!map.containsKey(s1)){
                return false;
            }
            for(char j:map.get(s1)){
                int len=sb.length();
                sb.append(j);
                if(helper(bottom,idx+1,sb,map)){
                    return true;
                }
                sb.setLength(len);
            }
        return false;
    }

    public static void main(String []args){
        Pyramidtransition pd=new Pyramidtransition();
        String []input={"XXX", "XXY", "XYX", "XYY", "YXZ"};
        System.out.println(pd.pyramidTransition("XXYX", Arrays.asList(input)));
    }
}

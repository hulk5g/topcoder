package Strings;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ksharma
 */
public class SimplifyPath {
    public String simplifyPath(String path) {
        StringBuilder result1=new StringBuilder("");
        List<String> result=new ArrayList<>();
        if(path==null || path.length()==0)return "/";
        String [] paths=path.split("/+");
        for(String p:paths){
            if(p.equals(".") || p.equals("")){

            }else if(p.equals("..")){
                if(result.size()>0){
                    result.remove(result.size()-1);
                }
            }else{
                result.add(p);
            }
        }
        if(result.size()==0)return "/";
        for(String s:result){
            result1.append("/").append(s);
        }
        return result1.toString();
    }

    public static void main(String []args){
        SimplifyPath sp=new SimplifyPath();
        System.out.println(sp.simplifyPath("/home//foo/"));
    }
}

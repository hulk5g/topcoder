package Backtracking;

import java.util.*;

/**
 * @author ksharma
 */
public class MinNoOfWords {
    int count=0;
    public List<String> findWords(Set<String> dict, String word){
        List<String>result=new ArrayList<>();
        List<String> temp=new ArrayList<>();
        Map<String,List<String>>mp=new HashMap<>();
        backTrack(dict,word,0,result,temp,Integer.MAX_VALUE,mp);
        System.out.println(count);
        return result;
    }

    public void backTrack(Set<String>dict, String word, int idx, List<String>result,
            List<String>temp,int maxSize,Map<String,List<String>>mp)
    {
        if(idx>=word.length()){
            if(maxSize>temp.size()){
                maxSize=temp.size();
                result.clear();
                result.addAll(new ArrayList<>(temp));
            }
            return;
        }


        for(int i=idx;i<=word.length();i++){
          //  count++;
            //sb.append(word.charAt(i));
            if(dict.contains(word.substring(idx,i))){
                temp.add(word.substring(idx,i));
                backTrack(dict,word,i,result,temp,maxSize,mp);
                temp.remove(temp.size()-1);
            }

        }
    }

    public static void main(String []args){
        MinNoOfWords mw=new MinNoOfWords();
        String []Dictionary={"jumped", "over","some", "thing","something"};
        String Word= "jumpedoversomething";
        System.out.println(mw.findWords(new HashSet<>(Arrays.asList(Dictionary)),Word));
    }

}

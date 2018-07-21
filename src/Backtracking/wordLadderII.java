package Backtracking;

import java.util.*;

/**
 * @author ksharma
 */
public class wordLadderII {
    int maxCount=Integer.MAX_VALUE;
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result=new ArrayList<>();
        Set<String>dict=new HashSet<>(wordList);
        if(!dict.contains(endWord))return result;
        Set<String>visited=new HashSet<>();
        List<String> temp=new ArrayList<String>();
        temp.add(beginWord);
        visited.add(beginWord);


        helper(beginWord,endWord,dict,result,temp,visited,1);
        return result;
    }

    private void helper(String beginWord, String endWord, Set<String> dict, List<List<String>> result,
            List<String> temp, Set<String> visited,int currentCount) {

        if(beginWord.equals(endWord)){
            if(currentCount==maxCount){
                result.add(new ArrayList<>(temp));
            }else if(currentCount<maxCount){
                result.clear();
                result.add(new ArrayList<>(temp));
                maxCount=currentCount;
                return;
            }
        }else if(currentCount==dict.size()){
            return;
        }

        for(int i=0;i<beginWord.length();i++){
            char c=beginWord.charAt(i);
            char[] charArray=beginWord.toCharArray();
            for(char j='a';j<'z';j++){
                charArray[i]=j;
                String toWord=String.valueOf(charArray);
                if(!visited.contains(toWord) && dict.contains(toWord)){
                    temp.add(toWord);
                    visited.add(toWord);
                    helper(toWord,endWord,dict,result,temp,visited,currentCount+1);
                    temp.remove(temp.size()-1);
                    visited.remove(toWord);
                    charArray[i]=c;
                }
            }
        }
    }

    public static void main(String []args){
        wordLadderII wl=new wordLadderII();
        String beginWord = "hit";
        String endWord = "cog";
        String []words={"hot","dot","dog","lot","log","cog"};
       List<String> wordList = Arrays.asList(words);
        System.out.println(wl.findLadders(beginWord,endWord,wordList));
    }
}

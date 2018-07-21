package graph;

import java.util.*;

/**
 * @author ksharma
 * 2 ended BFS
 */
public class WordLadderII {

    //2 ended BFS
    public List<List<String>> ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String>set1=new HashSet<>();
        Set<String>set2=new HashSet<>();
       // Set<String>visited=new HashSet<>();
        Set<String>tempSet;
        Map<String,List<String>>map=new HashMap<>();
        set1.add(beginWord);
        set2.add(endWord);
        //visited.add(beginWord);
        Set<String>dict=new HashSet<>(wordList);
        boolean flip=false;
        boolean done=false;
        boolean isL2R = true;
        dict.removeAll(set1);
        dict.removeAll(set2);
        while(!set1.isEmpty() && !set2.isEmpty()){
            tempSet=new HashSet<>();
            if(set1.size()>set2.size()){
                Set<String> temp=set1;
                set1=set2;
                set2=temp;
                flip=!flip;
                isL2R = !isL2R;
            }
            for(String word:set1){
                char []charArray=word.toCharArray();
                for(int i=0;i<word.length();i++){
                    char origChar=charArray[i];
                    for(char j='a';j<='z';j++){
                        charArray[i]=j;
                        String toWord=String.valueOf(charArray);
                        if(set2.contains(toWord)) {
                            done=true;
                            if(!flip) {
                                map.putIfAbsent(word, new ArrayList<>());
                                map.get(word).add(toWord);
                            }else{
                                map.putIfAbsent(toWord, new ArrayList<>());
                                map.get(toWord).add(word);
                            }

                        }
                        if(dict.contains(toWord)){
                            if(!flip) {
                                map.putIfAbsent(word, new ArrayList<>());
                                map.get(word).add(toWord);
                            }else{
                                map.putIfAbsent(toWord, new ArrayList<>());
                                map.get(toWord).add(word);
                            }
                            tempSet.add(toWord);
                          //  visited.add(toWord);
                        }
                    }
                    charArray[i]=origChar;
                }
            }
            set1=tempSet;
            dict.removeAll(tempSet);
            if(done)break;
        }

        List<List<String>>result=new ArrayList<>();
        List<String>temp=new ArrayList<>();
        temp.add(beginWord);
        helper(result,beginWord,endWord,map,temp);
        return result;
    }

    private void helper(List<List<String>> result, String beginWord, String endWord, Map<String, List<String>> map,
            List<String> temp) {
        if(beginWord.equals(endWord)){
            result.add(new ArrayList<>(temp));
            return;
        }
        if(!map.containsKey(beginWord))return;
        for(String s:map.get(beginWord)){
            temp.add(s);
            helper(result,s,endWord,map,temp);
            temp.remove(temp.size()-1);
        }
    }

    public static void main(String []args){
        WordLadderII wl=new WordLadderII();
        String []input={"a","b","c"};
        System.out.println(wl.ladderLength("a","c", Arrays.asList(input)));
    }
}

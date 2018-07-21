package graph;

import java.util.*;

/**
 * @author ksharma
 * 2 ended BFS
 */
public class WordLadder {

    //2 ended BFS
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord))return 0;
        Set<String>beginSet=new HashSet<>();
        Set<String> endSet=new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);
        Set<String> tempSet;
        Set<String> visited=new HashSet<>();
        Set<String>dict=new HashSet<>(wordList);
        visited.add(beginWord);
        int count=1;

        while(!beginSet.isEmpty() && !endSet.isEmpty()){
            tempSet=new HashSet<>();
            if(beginSet.size()>endSet.size()){
                Set<String> temp=beginSet;
                beginSet=endSet;
                endSet=temp;
            }
            for(String tempWord:beginSet){
                char[] charArray=tempWord.toCharArray();
                for(int i=0;i<charArray.length;i++){
                    char c =charArray[i];
                    for(char j='a';j<'z';j++){
                        charArray[i]=j;
                        String toWord=String.valueOf(charArray);
                        if(endSet.contains(toWord)) return count+1;
                        if(!visited.contains(toWord) && dict.contains(toWord)){
                            visited.add(toWord);
                            tempSet.add(toWord);
                        }
                    }
                    charArray[i]=c;
                }
            }
            count++;
            beginSet=tempSet;
        }
        return 0;
     }

    public static void main(String []args){
        WordLadder wl=new WordLadder();
        String []input={"hot","dog"};
        System.out.println(wl.ladderLength("hot","dog", Arrays.asList(input)));
    }
}

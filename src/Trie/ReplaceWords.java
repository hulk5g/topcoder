package Trie;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author ksharma
 */
public class ReplaceWords {
    class TrieNodes{
        TrieNodes[] children=new TrieNodes[26];
        boolean isEnd;
    }
    public void insert(TrieNodes root, String key){
        TrieNodes tNode=root;
        for(int i=0;i<key.length();i++){
            int index=key.charAt(i)-'a';
            if(tNode.children[index] !=null){
                tNode=tNode.children[index];
            }else{
                TrieNodes temp=new TrieNodes();
                tNode.children[index]=temp;
                tNode=tNode.children[index];
            }
        }
        tNode.isEnd=true;
    }

    public String search(TrieNodes root, String key,Set<String>set){
        TrieNodes tNode=root;
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<key.length();i++){
            int index=key.charAt(i)-'a';
            if(tNode.children[index]!=null){
                sb.append(key.charAt(i));
                tNode=tNode.children[index];
                if(tNode.isEnd){
                    break;
                }
            }else{
                break;
            }
        }
      return (sb.length()>0 && set.contains(sb.toString()))?sb.toString():null;
    }

    public String replaceWords(List<String> dict, String sentence) {
        TrieNodes root=new TrieNodes();
        Set<String> set=new HashSet<>();
        for(String word:dict){
            insert(root,word);
            set.add(word);
        }
        String [] sentenceArray=sentence.split(" ");
        StringBuilder result=new StringBuilder();
        for(int i=0;i<sentenceArray.length;i++){
            String orig=sentenceArray[i];
            String r=search(root,orig,set);
            if(r!=null){
                sentenceArray[i]=r;
            }
            result.append(sentenceArray[i]).append(" ");
            if(i==sentenceArray.length-1){
                result.deleteCharAt(result.length()-1);
            }
        }
        return result.toString();
    }

    public static void main(String []args){
        ReplaceWords rw=new ReplaceWords();
        String []dict = {"cat", "bat", "rat"};
        String sentence = "the cattle was rattled by the battery";
        System.out.println(rw.replaceWords(Arrays.asList(dict),sentence));
    }
}

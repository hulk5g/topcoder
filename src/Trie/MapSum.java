package Trie;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ksharma
 */
public class MapSum {

    class TrieNodes{
        int val;
        TrieNodes []children=new TrieNodes[26];
        boolean isEnd;
    }
        TrieNodes root;
        public MapSum() {
            root=new TrieNodes();
        }

        public void insert(String key, int val) {
            TrieNodes current=root;
            for(int i=0;i<key.length();i++){
                int index=key.charAt(i)-'a';
                if(current.children[index]!=null){
                    current=current.children[index];
                }else{
                    TrieNodes n=new TrieNodes();
                    current.children[index]=n;
                    current=n;
                }
            }
            current.isEnd=true;
            current.val=val;
        }

        public int sum(String prefix) {
            TrieNodes current=root;
            int val=0;
            for(int i=0;i<prefix.length();i++){
                int index=prefix.charAt(i)-'a';
                if(current.children[index]==null){
                    return 0;
                }else{
                    current=current.children[index];
                }
            }

            Queue<TrieNodes>q=new LinkedList<>();
            q.offer(current);
            while(!q.isEmpty()){
                TrieNodes trieNodes=q.poll();
                if(trieNodes!=null){
                    if(trieNodes.isEnd){
                        val+=trieNodes.val;
                    }
                    for(int i=0;i<26;i++){
                        if(trieNodes.children[i]!=null){
                            q.offer(trieNodes.children[i]);
                        }
                    }
                }
            }
            return val;
        }

        public static void main(String []args){
            MapSum obj = new MapSum();
             obj.insert("apple", 3);
            System.out.println(obj.sum("ap"));
             obj.insert("app", 2);
            System.out.println(obj.sum("ap"));
            obj.insert("apple", 7);
            System.out.println(obj.sum("ap"));
        }
}

package Trie;

/**
 * @author ksharma
 */
/*
Given many words, words[i] has weight i.

Design a class WordFilter that supports one function, WordFilter.f(String prefix, String suffix). It will return the word with given prefix and suffix with maximum weight. If no word exists, return -1.

Examples:
Input:
WordFilter(["apple"])
WordFilter.f("a", "e") // returns 0
WordFilter.f("b", "") // returns -1
Note:
words has length in range [1, 15000].
For each test case, up to words.length queries WordFilter.f may be made.
words[i] has length in range [1, 10].
prefix, suffix have lengths in range [0, 10].
words[i] and prefix, suffix queries consist of lowercase letters only.
 */
public class WordFilter {
    private Trie root;
    private int max;
    class Trie{
        Trie []child;
        Integer weight;
        String word;

        public Trie(){
            child=new Trie[26];
        }
    }

    private void insert(Trie root,String w, int index){
        Trie curr=root;
        for(int i=0;i<w.length();i++){
            int idx=w.charAt(i)-'a';
            if(curr.child[idx]==null){
                Trie node=new Trie();
                curr.child[idx]=node;
            }
            curr=curr.child[idx];
        }
        curr.weight=index;
        curr.word=w;
    }
    public WordFilter(String[] words) {
        this.root=new Trie();
        max=-1;
        for(int i=0;i<words.length;i++){
            insert(root,words[i],i);
        }
    }

    public int f(String prefix, String suffix) {
        return search(root,prefix,suffix);
    }

    private int search(Trie root, String prefix, String suffix) {
        Trie curr=root;
        for(int i=0;i<prefix.length();i++){
            int idx=prefix.charAt(i)-'a';
            if(curr.child[idx]==null) return -1;
            curr=curr.child[i];
        }
        recur(curr,suffix);
        return max;
    }

    private void recur(Trie curr, String suffix) {
        if(curr==null)return;
        if(curr.word!=null){
            String s1=curr.word;
            if(s1.endsWith(suffix) && curr.weight>max){
                max=curr.weight;
            }
        }
        for(int i=0;i<26;i++){
            if(curr.child[i]!=null){
                recur(curr.child[i],suffix);
            }
        }
    }

    public static void main(String []args){
        WordFilter wf=new WordFilter(new String[]{"apple"});
        System.out.println(wf.f("a","e"));
    }
}

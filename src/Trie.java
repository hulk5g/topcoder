/**
 * @author ksharma
 */
public class Trie {
    static class TrieNode{
        TrieNode [] children=new TrieNode[26];
        boolean isEnd=false;
    }

    public void insert(TrieNode root, String key){
        TrieNode tNode=root;
        for(int i=0;i<key.length();i++){
            int index=key.charAt(i)-'a';
            if(tNode.children[index] !=null){
                tNode=tNode.children[index];
            }else{
                TrieNode temp=new TrieNode();
                tNode.children[index]=temp;
                tNode=tNode.children[index];
            }
        }
        tNode.isEnd=true;
    }

    public boolean search(TrieNode root, String key){
        TrieNode tNode=root;
        for(int i=0;i<key.length();i++){
            int index=key.charAt(i)-'a';
            if(tNode.children[index]!=null){
                tNode=tNode.children[index];
            }else{
                return false;
            }
        }
        if(tNode!=null && tNode.isEnd)
            return true;
        return false;
    }

    public static void main(String []args){
        Trie t=new Trie();
        TrieNode root=new Trie.TrieNode();
        String keys[] = {"the", "a", "there", "answer", "any",
                "by", "bye", "their"};
        for(int i=0;i<keys.length;i++)
            t.insert(root,keys[i]);
        System.out.println(t.search(root,"byeaw"));

    }
}

package Trie;

/**
 * @author ksharma
 */
 class TrieNodes{
     char val;
     TrieNodes []children=new TrieNodes[26];
     boolean isEnd=false;
}
public class LongestWordIndict {

    public String longestWord(String[] words) {
        TrieNodes root=new TrieNodes();
        for(String s:words){
            insert(root,s);
        }
        return dfs(root).toString();
    }

    private StringBuilder dfs(TrieNodes root){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<26;i++){
            if(root.children[i]!=null && root.children[i].isEnd){
                StringBuilder temp=new StringBuilder();
                temp.append(root.children[i].val);
                temp.append(dfs(root.children[i]));
                if(temp.length()>sb.length()){
                    sb=temp;
                }
            }
        }
        return sb;
    }

    private void insert(TrieNodes root, String s) {
        TrieNodes current=root;
        for(int i=0;i<s.length();i++){
            int index=s.charAt(i)-'a';
            if(current.children[index]!=null){
                current=current.children[index];
            }else{
                TrieNodes n=new TrieNodes();
                n.val=s.charAt(i);
                current.children[index]=n;
                current=n;
            }
        }
        current.isEnd=true;

    }

    public static void main(String []args){
        LongestWordIndict lw=new LongestWordIndict();
        String []words={"yo","ew","fc","zrc","yodn","fcm","qm","qmo","fcmz","z","ewq","yod","ewqz","y"};
        System.out.println(lw.longestWord(words));
    }

}

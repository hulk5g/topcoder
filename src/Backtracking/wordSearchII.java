package Backtracking;

import java.util.*;

/**
 * @author ksharma
 */

public class wordSearchII {
    class Trie{
        Trie [] children;
        String word;

        public Trie(){
            children=new Trie[26];
        }
    }
    int []row={1,-1,0,0};
    int []col={0,0,1,-1};
    List<String>result=new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {
        Trie root=new Trie();
        for(String s:words){
            insert(root,s);
        }
        int m=board.length;
        int n=board[0].length;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dfs(board,i,j,root);

            }
        }
        return result;
    }

    private void insert(Trie root, String s) {
        Trie current=root;
        for(int i=0;i<s.length();i++){
            int id=s.charAt(i)-'a';
            if(current.children[id]!=null){
                current=current.children[id];
            }else{
                Trie node=new Trie();
                current.children[id]=node;
                current=node;
            }
        }
        current.word=s;
    }


    private void dfs(char[][] board, int r, int c,Trie root) {

        int valIdx=board[r][c]-'a';
        char origC=board[r][c];
        board[r][c]='1';
        if(root.children[valIdx]!=null) {
            root=root.children[valIdx];
            if(root.word!=null){
                result.add(root.word);
                root.word=null;
            }
            for (int k = 0; k < 4; k++) {
                int xx = r + row[k];
                int yy = c + col[k];
                if (xx >= 0 && xx < board.length && yy >= 0 && yy < board[0].length && board[xx][yy]!='1') {
                     dfs(board, xx, yy, root);
                }
            }
        }
        board[r][c]=origC;
    }

    public static void main(String []args){
        wordSearchII ws=new wordSearchII();
        String [] words = {"a"};
        char [][]board= {{'a', 'a'}};
        System.out.println(ws.findWords(board,words));
    }
}

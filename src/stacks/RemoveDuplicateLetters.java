package stacks;

import java.util.Stack;

/**
 * @author ksharma
 */
public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        Stack<Character>st=new Stack<>();
        int []count = new int[26];
        boolean [] visited=new boolean[26];
        char [] arr=s.toCharArray();
        for(int i=0;i<arr.length;i++){
            count[arr[i]-'a']++;
        }

        for(int i=0;i<arr.length;){
            int idx=arr[i]-'a';
            count[idx]--;
            if(visited[idx]){
                i++;
                continue;
            }
            while (!st.isEmpty() && st.peek() > arr[i] && count[st.peek() - 'a'] > 0) {
                visited[st.peek() - 'a'] = false;
                st.pop();
            }
            st.push(arr[i]);
            visited[idx] = true;
            i++;
        }

        StringBuilder sb=new StringBuilder();
        for(char c :st){
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String []args){
        RemoveDuplicateLetters rd=new RemoveDuplicateLetters();
        System.out.println(rd.removeDuplicateLetters("cbacdcbc"));
    }
}

package stacks;

import java.util.Stack;

/**
 * @author ksharma
 */
public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        Stack<Character>st=new Stack<>();

        for(int i=0;i<num.length();){
            if( k>0 && !st.isEmpty() && st.peek()>num.charAt(i)){
                k--;
                st.pop();
                continue;
            }
            st.push(num.charAt(i));
            i++;
        }

        while(k>0){
            st.pop();
            k--;
        }
        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        while(sb.length() > 1 && sb.charAt(sb.length()-1) == '0') {
            sb.deleteCharAt(sb.length() - 1);
        }

        return sb.length()==0?"0":sb.reverse().toString();
    }
    public static void main(String []args){
        String s="1234567890";
        RemoveKDigits rd=new RemoveKDigits();
        System.out.println(rd.removeKdigits(s,9));
    }
}

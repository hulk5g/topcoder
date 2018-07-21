package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author ksharma
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        return solution2(n);
    }

    public List<String> solution1(int n){
        List<String> result=new ArrayList<>();
        char[] temp=new char[2*n];
        Arrays.fill(temp,'e');
        temp[0]='(';
        temp[2*n-1]=')';
        helper(result,temp,n,1);
        return result;
    }

    public List<String> solution2(int n){
        List<String> result=new ArrayList<>();
        helper2(n,result,new StringBuilder(),0,0);
        return result;
    }

    private void helper2(int n, List<String> result, StringBuilder temp, int openCount, int closeCount) {
        if(temp.length()>=2*n){
            if(isValid(temp.toString().toCharArray())){
                result.add(temp.toString());
                return;
            }
        }

        if(openCount<n){
            helper2(n,result,temp.append("("),openCount+1,closeCount);
            temp.deleteCharAt(temp.length()-1);
        }
        if(closeCount<n){
            helper2(n,result,temp.append(")"),openCount,closeCount+1);
            temp.deleteCharAt(temp.length()-1);
        }
    }

    private void helper(List<String> result, char[] temp, int n, int index) {
        if(index>2*n-2){
            if(isValid(temp)){
                result.add(String.valueOf(temp));
            }
            return;
        }
        if(isSafe(temp,index)){
            temp[index]='(';
            helper(result,temp,n,index+1);
            temp[index]='e';
        }
        if(isSafe(temp,index)){
            temp[index]=')';
            helper(result,temp,n,index+1);
            temp[index]='e';
        }
    }

    private boolean isValid(char[] temp) {
        Stack<Character>st=new Stack<>();
        for(char c:temp){
            if(c=='('){
                st.push(c);
            }else{
                if(st.isEmpty()){
                    return false;
                }
                st.pop();
            }
        }
        if(st.size()==0)
            return true;
        return false;
    }

    private boolean isSafe(char[] temp, int index) {
        if(temp[index]=='e')
            return true;
        return false;
    }

    public static void main(String []args){
        int n=3;
        GenerateParentheses gp=new GenerateParentheses();
        System.out.println(gp.generateParenthesis(n));
    }
}

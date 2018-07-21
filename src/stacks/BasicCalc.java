package stacks;

import java.util.Stack;

/**
 * @author ksharma
 */
public class BasicCalc {
    public int calculate(String s) {
        int n=s.length();
        Stack<Integer> st=new Stack<>();
        char prevSign='+';
        for(int i=0;i<s.length();){
            if(Character.isDigit(s.charAt(i))){
                int idx=i;
                while(idx<n && Character.isDigit(s.charAt(idx))){
                    idx++;
                }
                int a=Integer.parseInt(s.substring(i,idx));
                st.push(a);
                i=idx;
            }else if(s.charAt(i)==' ' || s.charAt(i)=='+' || s.charAt(i)=='(' || s.charAt(i)==')'){
                i++;
            }else{
                int idx2=i;
                while(idx2<n && !Character.isDigit(s.charAt(idx2))){
                    idx2++;
                }
                int idx3=idx2;
                while(idx3<n && Character.isDigit(s.charAt(idx3))){
                    idx3++;
                }
                int a=Integer.parseInt(s.substring(idx2,idx3));
                st.push(-a);
                i=idx3;
            }
        }
        int sum=0;
        while(!st.isEmpty()){
            sum+=st.pop();
        }
        return sum;
    }

    public static void main(String []args){
        BasicCalc bc=new BasicCalc();
        System.out.println(bc.calculate("(1+(4+5+2)-3)+(6+8)"));
    }
}

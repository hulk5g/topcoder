package stacks;

import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

/**
 * @author ksharma
 */
public class AtomsCounts {
    public String countOfAtoms(String formula) {
        Stack<TreeMap<String,Integer>>st=new Stack<>();
        st.push(new TreeMap<>());
        int i=0;
        while(i<formula.length()){
          if(formula.charAt(i)=='('){
              st.push(new TreeMap<>());
              i++;
          }else if(formula.charAt(i)==')'){
              Map<String,Integer> top=st.pop();
              int idx=i+1;
              while(idx<formula.length() && Character.isDigit(formula.charAt(idx))){
                  idx++;
              }
              int mul=(i+1==idx)?1:Integer.parseInt(formula.substring(i+1,idx));
              for(Map.Entry<String,Integer> e:top.entrySet()){
                  e.setValue(e.getValue()*mul);
                  st.peek().put(e.getKey(),st.peek().getOrDefault(e.getKey(),0)+e.getValue());
              }
              i=idx;
          }else if(Character.isUpperCase(formula.charAt(i))){
              int idx=i+1;
              TreeMap<String,Integer> top=st.pop();
              while(idx<formula.length() && Character.isLowerCase(formula.charAt(idx))){
                  idx++;
              }
              String atom=formula.substring(i,idx);
              i=idx;
              while(idx<formula.length()&& Character.isDigit(formula.charAt(idx))){
                  idx++;
              }
              int count=i==idx?1:Integer.parseInt(formula.substring(i,idx));
              top.put(atom,top.getOrDefault(atom,0)+count);
              st.push(top);
              i=idx;
          }
        }

        StringBuilder result=new StringBuilder();
        for(Map.Entry<String,Integer>e:st.pop().entrySet()){
            result.append(e.getKey());
            if(e.getValue()>1){
                result.append(e.getValue());
            }
        }
        return result.toString();
    }

    public  static void main(String []args){
        String formula="K4(ON(SO3)2)2";
        AtomsCounts ac=new AtomsCounts();
        System.out.println(ac.countOfAtoms(formula));
    }
}

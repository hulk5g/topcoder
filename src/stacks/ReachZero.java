package stacks;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @author ksharma
 */
public class ReachZero {
    public boolean canReachZeroRecursive(int []arr,int index){
        if(arr[index]==0)return true;
        Set<Integer>visited=new HashSet<>();

        return helper(arr,index,visited);
    }

    public boolean helper(int []arr,int index,Set<Integer>visited){
        if(index<0 || index>=arr.length)return false;
        else if(arr[index]==0)return true;
        visited.add(index);
        if(!visited.contains(index)){
            return helper(arr,index-arr[index],visited)||helper(arr,index+arr[index],visited);
        }
       return false;
    }

    public boolean canReachZero(int []arr,int index){
        Stack<Integer>st=new Stack<>();
        Set<Integer>visited=new HashSet<>();
        st.push(index);
        while(!st.isEmpty()){
            int idx=st.pop();
            visited.add(idx);
            if(arr[idx]==0)return true;
            int nei=idx+arr[idx];
            if(0<=nei && nei<=arr.length && !visited.contains(nei)){
                st.push(nei);
            }
            nei=idx-arr[idx];
            if(0<=nei && nei<=arr.length && !visited.contains(nei)){
                st.push(nei);
            }
        }
        return false;
    }

    public static void main(String []args){
        int []arr={1,3,2,0,4,2,1};
        ReachZero rz=new ReachZero();
        System.out.println(rz.canReachZeroRecursive(arr,1));
    }
}

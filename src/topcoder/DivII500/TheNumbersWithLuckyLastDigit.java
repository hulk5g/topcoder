package topcoder.DivII500;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ksharma
 */
public class TheNumbersWithLuckyLastDigit {

    Map<Integer,Integer>hm=new HashMap<>();
    public int find(int n){
        return helper(n,1);
    }

    public int helper(int target,int count){
        if(target % 10==4 || target%10==7){
            return count;
        }else if(target<4 || (4<target && target<7)||target==8||target==9){
            return -1;
        }
        if(hm.containsKey(target))return hm.get(target);
        int result=-1;
        for(int i=4,j=7;i<=target||j<=target;i=i+10,j=j+10){
            int temp1=helper(target-i,count+1);
            if(temp1!=-1)result=temp1;
            int temp2=helper(target-i,count+1);
            if(temp2!=-1){
                if(result==-1)result=temp2;
                else
                    result= Math.min(result,temp2);
            }
            hm.put(target,result);
        }
        return result;
    }

    public static void main(String[] args) {
        TheNumbersWithLuckyLastDigit ld=new TheNumbersWithLuckyLastDigit();
        System.out.println(ld.find(1234567));
    }
}

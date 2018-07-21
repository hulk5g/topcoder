package greedy;

import java.util.Arrays;

/**
 * @author ksharma
 */

public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        if(s.length==0)return 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int count=0;
        int j=0;
        for(int i=0;i<g.length && j<s.length;){
            if(s[j]>=g[i]){
                count++;
                j++;i++;
            }else{
                j++;
            }
        }
        return count;
    }

    public static void main(String []args){
        AssignCookies ac=new AssignCookies();
        int [] c={7,8,9,10};
        int []cookies={5,6,7,8};
        System.out.println(ac.findContentChildren(c,cookies));
    }
}

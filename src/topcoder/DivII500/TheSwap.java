package topcoder.DivII500;

import java.util.*;

/**
 * @author ksharma
 */
public class TheSwap {
    /*
    HashSet <String> [] h;

  void go (String x, int k) {
    if (h[k].contains (x)) return;
    h[k].add (x);
    if (k == 0) return;
    char [] z = x.toCharArray ();
    for (int i = 0; i < z.length; i++)
      for (int j = i + 1; j < z.length; j++)
        if (i != 0 || z[j] != '0') {
          char t = z[i]; z[i] = z[j]; z[j] = t;
          go (new String (z), k - 1);
               t = z[i]; z[i] = z[j]; z[j] = t;
        }
  }
     */
    public int findMax(int n, int k){
        String s=""+n;
        HashSet<String>[]set=new HashSet[k+1];
        for(int i=0;i<=k;i++){
            set[i]=new HashSet<>();
        }
        helper(s,k,set);
        String max="";
        for(String s1:set[0]){
            if(s1.compareTo(max)>0){
                max=s1;
            }
        }
        return Integer.parseInt(max);
    }

    public void helper(String s,int k,HashSet<String>[]set){
        if(set[k].contains(s))return;
        set[k].add(s);
        if(k==0)return;
        char []arr=s.toCharArray();
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(i!=0 || arr[j]!='0'){
                    char c=arr[i];
                    arr[i]=arr[j];
                    arr[j]=c;
                    helper(new String(arr),k-1,set);
                    char cTemp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=cTemp;
                }
            }
        }
    }

    public static void main(String[] args) {
        TheSwap ts=new TheSwap();
        System.out.println(ts.findMax(436659,2));
    }
}

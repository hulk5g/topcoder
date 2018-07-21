package DP;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ksharma
 */
public class SoupIngredient {
    static class Soup{
        int ingredient;
        int servings;
        public Soup(int i,int s){
            this.ingredient=i;
            this.servings=s;
        }
    }

    public int getMaxServings(List<Soup> list,int w){
        return sol2(list,w);
    }

    private int sol2(List<Soup> list,int w){
        int [][]dp=new int[list.size()+1][w+1];

        for(int i=0;i<=list.size();i++){
            dp[i][0]=0;
        }
        for(int j=1;j<=w;j++){
            dp[0][j]=Integer.MIN_VALUE;
        }
        for(int i=1;i<=list.size();i++){
            for(int j=1;j<=w;j++){
                    dp[i][j]=dp[i-1][j];
                    if(list.get(i-1).ingredient<=j && dp[i][j-list.get(i-1).ingredient]>=0){
                            dp[i][j]=Math.max(dp[i][j],dp[i][j-list.get(i-1).ingredient]+list.get(i-1).servings);
                    }
            }
        }
        return dp[list.size()][w];
    }

    private int sol1(List<Soup> list, int w, int currW, int currVal) {
        if(currW==w){
            return currVal;
        }
        int val=Integer.MIN_VALUE;
        for(int i=0;i<list.size();i++){
            if(list.get(i).ingredient <=w-currW){
                int t=sol1(list,w,currW+list.get(i).ingredient,currVal+list.get(i).servings);
                val=Math.max(val,t);
            }
        }
        return val;
    }

    public static void main(String []args){
        SoupIngredient si=new SoupIngredient();
        List<Soup> list=new ArrayList<>();
        list.add(new Soup(2,4));
        list.add(new Soup(3,5));
        list.add(new Soup(4,9));
        list.add(new Soup(5,10));
        list.add(new Soup(7,17));
        System.out.println(si.getMaxServings(list,6));
    }
}

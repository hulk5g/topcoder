package Strings;

/**
 * @author ksharma
 */
public class MinDistance {
    public int minDistance(String word1, String word2) {
        if(word2.length()<word1.length()){
            String temp=word1;
            word1=word2;
            word2=temp;
        }
        return helper(word1,word2, word1.length()-1,word2.length()-1);

    }
    public int helper(String word1,String word2, int m,int n){
        if(word1==null ||m<0)return n+1;
        else if(word2==null || n<0)return m+1;
        else if(word1.charAt(m)==word2.charAt(n)){
            return helper(word1,word2,m-1,n-1);
        }else{
            return 1+helper(word1,word2,m,n-1);
        }
    }
    public static void main(String []args){
        MinDistance md=new MinDistance();
        System.out.println(md.minDistance("ab","a"));
    }
}

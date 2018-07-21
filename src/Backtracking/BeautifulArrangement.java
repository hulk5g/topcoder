package Backtracking;

/**
 * @author ksharma
 */
public class BeautifulArrangement {
    int count=0;
    public int countArrangement(int N) {
       boolean []visited=new boolean[N+1];
        helper(N,1,visited);
        return count;
    }

    private void helper(int n, int idx, boolean []visited) {
        if(idx>n){
            count++;
            return;
        }
        for(int i=1;i<=n;i++){
            if(!visited[i] && (idx%i==0 || i%idx==0)){
                    visited[i]=true;
                    helper(n,idx+1,visited);
                    visited[i]=false;
                }

        }
    }

    public static void main(String []args){
        BeautifulArrangement ba=new BeautifulArrangement();
        System.out.println(ba.countArrangement(2));
    }
}

package topcoder.DivII250;

/**
 * @author ksharma
 */
public class TeamsSelection {
    String simulate(int[] preference1, int[] preference2){
        char []arr=new char[preference1.length];
        boolean []visited=new boolean[51];
        int i=0,j=0;
        int n=preference1.length;
        while(i<n || j<n){
            while(i<n && visited[preference1[i]]){
                i++;
            }
            if(i<n){
                arr[preference1[i]-1]='1';
                visited[preference1[i]]=true;
                i++;
            }

            while(j<n && visited[preference2[j]]){
                j++;
            }
            if(j<n){
                arr[preference2[j]-1]='2';
                visited[preference2[j]]=true;
                j++;
            }


        }

        return String.valueOf(arr);
    }

    public static void main(String []args){
        TeamsSelection ts=new TeamsSelection();
        System.out.println(ts.simulate(new int[]{3, 2, 1},new int[]{1, 3, 2}));
    }
}

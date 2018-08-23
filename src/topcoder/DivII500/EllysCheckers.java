package topcoder.DivII500;

/**
 * @author ksharma
 */
public class EllysCheckers {

    public String getWinner(String board){
        char[]arr=board.toCharArray();
        int checkCount=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]=='o')checkCount++;
        }
        boolean result=helper(arr,0,checkCount,arr.length);
        if(result)return "YES";
        return "NO";
    }

    public boolean helper(char[]arr,int turn,int checkCount,int n){
        if(checkCount==0){
            if(turn==0)return false;
            return true;
        }else if(arr[n-1]=='o'){
            arr[n-1]='.';
            return helper(arr,turn,checkCount-1,n);
        }
        boolean ans=true;
        for(int i=0;i<n;i++){
            if(arr[i]=='o'){
                arr[i]='.';
                if(i<n-1 && arr[i+1]=='.'){
                    arr[i+1]='o';
                    ans=ans&helper(arr,~turn,checkCount,n);
                    arr[i+1]='.';
                }else if(i<n-3 && arr[i+1]=='o' && arr[i+2]=='o'){
                    arr[i+3]='o';
                    ans=ans&helper(arr,~turn,checkCount,n);
                    arr[i+3]='.';
                }
                arr[i]='o';

            }
        }
        if(turn==0 && ans)return true;
        else if(turn==-1 && !ans)return true;
        return false;
    }

    public static void main(String[] args) {
        EllysCheckers c=new EllysCheckers();
        System.out.println(c.getWinner(".o...ooo..oo.."



        ));
    }
}

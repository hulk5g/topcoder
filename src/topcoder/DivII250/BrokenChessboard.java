package topcoder.DivII250;

/**
 * @author ksharma
 */
public class BrokenChessboard {
    int minimumFixes(String[] board){
        String prev=null;
        int count=0;
        for(int i=0;i<board.length;i++){
            char[] curr=board[i].toCharArray();
            for(int j=0;j<curr.length;j++){
                int left=j-1;
                int upper=prev!=null?j:-1;
                if( (left>=0 &&curr[left]==curr[j]) || (upper>=0 && curr[j]==prev.charAt(upper))){
                    curr[j]= curr[j]=='B'?'W':'B';
                    count++;
                }
            }
            prev=String.valueOf(curr);
        }
        return count;
    }

    public static void main(String []args){
        BrokenChessboard bc=new BrokenChessboard();
        System.out.println(bc.minimumFixes(new String[]{"BWBBB", "WWBBW", "BBBBW", "WBWBB"}));
    }
}

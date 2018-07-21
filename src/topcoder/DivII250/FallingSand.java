package topcoder.DivII250;

/**
 * @author ksharma
 */
public class FallingSand {
    public  String[] simulate(String[] board){
        for(int i=0;i<board.length;i++){
            StringBuilder first=new StringBuilder(board[0]);
            if(i!=board.length-1){
                StringBuilder second=new StringBuilder(board[i+1]);
                for(int j=0;j<first.length();j++){
                    if(first.charAt(j)=='o' && (second.charAt(j)=='.'||second.charAt(j)=='o')){
                        first.setCharAt(j,'.');
                        second.setCharAt(j,'o');
                    }
                }
                board[i+1]=second.toString();
            }
            board[i]=first.toString();

        }
        return board;
    }
}

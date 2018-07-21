package topcoder.DivII500;

/**
 * @author ksharma
 */
public class MathContest {
    int top=0;
    int bottom=0;
    boolean changeColor=false;
    boolean topReversed=false;
    int count=0;
    public 	int countBlack(String ballSequence, int repetitions){
        bottom=ballSequence.length()-1;
        while( (top<bottom && !topReversed)||(bottom<top && topReversed)){
            char c=ballSequence.charAt(top);
            if(c=='B'){
                if(changeColor){
                    doWhiteThing();
                }
                else{
                    doBlackThing();
                }
            }else{
                if(changeColor){
                    doBlackThing();
                }else{
                    doWhiteThing();
                }
            }
        }
        return count*repetitions;
    }

    public void doBlackThing(){
        changeColor=!changeColor;
        if(topReversed){
            top--;
        }else{
            top++;
        }
        count++;
    }

    public void doWhiteThing(){
        if(topReversed){
            top--;
        }else{
            top++;
        }
        int temp=top;
        top=bottom;
        bottom=temp;
        topReversed=!topReversed;
    }

    public static void main(String[] args) {
        MathContest mc=new MathContest();
        System.out.println(mc.countBlack("BBWWB",1));
    }
}

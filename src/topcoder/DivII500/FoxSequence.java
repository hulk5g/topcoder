package topcoder.DivII500;

/**
 * @author ksharma
 */
public class FoxSequence {

    public 	String isValid(int[] seq){
        if(seq.length<4)return "NO";
        int cd=seq[1]-seq[0];
        if(cd<=0)return "NO";
        int i=2;
        for(;i<seq.length;i++){
            if(seq[i]>seq[i-1]){
                if(seq[i]-seq[i-1]!=cd)return "NO";
            }else{
                break;
            }
        }
        cd=seq[i]-seq[i-1];
        if(cd>=0)return "NO";
        for(i=i+1;i<seq.length;i++){
            if(seq[i]<seq[i-1]){
                if(seq[i]-seq[i-1]!=cd)return "NO";
            }else{
                break;
            }
        }
        while(seq[i]==seq[i-1])i++;
        if(i>=seq.length-1)return "NO";
        cd=seq[i+1]-seq[i];
        for(i=i+2;i<seq.length;i++){
            if(seq[i]>seq[i-1]){
                if(seq[i]-seq[i-1]!=cd)return "NO";
            }else{
                break;
            }
        }
        cd=seq[i]-seq[i-1];
        if(cd>=0)return "NO";
        for(i=i+1;i<seq.length;i++){
            if(seq[i]<seq[i-1]){
                if(seq[i]-seq[i-1]!=cd)return "NO";
            }else{
                break;
            }
        }
        return i==seq.length?"YES":"NO";
    }

    public static void main(String[] args) {
        FoxSequence fs=new FoxSequence();
        System.out.println(fs.isValid(new int[]
                {6,1,6}
        ));
    }
}

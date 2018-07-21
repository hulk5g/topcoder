import java.util.ArrayList;
import java.util.List;

/**
 * @author ksharma
 */
public class BinaryWatch {
    public List<String> readBinaryWatch(int num) {

        List<String>result=new ArrayList<>();

        int []hours={1, 2, 4, 8};
        int []minutes={1, 2, 4, 8, 16, 32};
        backtrack(result,hours,minutes,0,0,num,0);
        return result;


    }

    public void backtrack(List<String> result,int[]hours, int[]minutes,int hour,int minute,int num,int start){
        if(num==0){
            result.add((hour +  (minute < 10 ?  ":0" : ":") + minute));
            return;
        }
        for(int i=start;i<hours.length+minutes.length;i++){
            if(i<hours.length){
                if(hour+hours[i]<12){
                    backtrack(result,hours,minutes,hour+hours[i],minute,num-1,start+1);
                }
            }else{
               if(minute+minutes[i-hours.length]<60){
                   backtrack(result,hours,minutes,hour,minute+minutes[i-hours.length],num-1,start+1);
               }
            }
        }
    }

    public static void main(String []args){
        BinaryWatch bw=new BinaryWatch();
        int n=3;
        System.out.println(bw.readBinaryWatch(n));
    }
}

package topcoder.DivII500;

import java.util.Arrays;

/**
 * @author ksharma
 */
public class RollingDiceDivTwo {
    public int minimumFaces(String[] rolls){
        int []max=new int[rolls[0].length()];
        for(int i=0;i<rolls.length;i++){
            char[] arr=rolls[i].toCharArray();
            Arrays.sort(arr);
            for(int j=0;j<rolls[0].length();j++){
                max[j]=Math.max(max[j],arr[j]-'0');
            }
        }
        int sum=0;
        for(int i:max){
            sum+=i;
        }
        return sum;
    }

    public static void main(String[] args) {
        RollingDiceDivTwo rd=new RollingDiceDivTwo();
        System.out.println(rd.minimumFaces(new String[]{"281868247265686571829977999522", "611464285871136563343229916655", "716739845311113736768779647392", "779122814312329463718383927626",
                "571573431548647653632439431183", "547362375338962625957869719518", "539263489892486347713288936885", "417131347396232733384379841536"}));
    }
}

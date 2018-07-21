package topcoder.DivII500;

/**
 * @author ksharma
 */
public class TheLuckyGameDivTwo {

    public int find(int a, int b, int jLen, int bLen){
        int count=0;
        int min=Integer.MAX_VALUE;
        int n=b-a;
        for(int i=a;i<a+jLen && i<=b;i++){
            for(int j=i;j<i+bLen;j++){
                if(onlyFourAndSeven(j)){
                    count++;
                    min=Math.min(min,count);
                }
            }
        }
        return min==Integer.MAX_VALUE?0:min;
    }

    private boolean onlyFourAndSeven(int j) {
        while(j>10){
            int a=j%10;
            j=j/10;
            if(a!=4 && a!=7){
                return false;
            }
        }
        if(j!=4 && j!=7)return false;
        return true;
    }

    public static void main(String[] args) {
        TheLuckyGameDivTwo tt=new TheLuckyGameDivTwo();
        System.out.println(tt.find(1,100,100,100));
    }
}

package topcoder.DivII500;

/**
 * @author ksharma
 */
public class DrawingMarbles {
    public 	double sameColor(int[] colors, int n){
        int sum=0;
        for(int i:colors){
            sum+=i;
        }
        double result=0.0;
        for(int i=0;i<colors.length;i++){
            if(colors[i]>=n){
                double sameColor=colors[i];
                int trials=0;
                double temp=1;
                while(trials<n){
                    temp*= (sameColor-trials)/(sum-trials);
                    trials++;
                }
                result+=temp;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        DrawingMarbles dm=new DrawingMarbles();
        System.out.println(dm.sameColor(new int[]{ 5, 6, 7 },2));
    }
}

package DP;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.List;

/**
 * @author ksharma
 */
public class FallingSquare {

    public List<Integer> fallingSquares(int[][] positions) {
        Integer height[]=new Integer[positions.length];
        Pair<Long,Long> [] interval=new Pair[positions.length];
        height[0]=positions[0][1];
        interval[0]=new Pair<Long,Long>(Long.valueOf(positions[0][0]),Long.valueOf(positions[0][0]+positions[0][1]));

        for(int i=1;i<positions.length;i++){
            height[i]=Math.max(positions[i][1],height[i-1]);
            interval[i]=new Pair<Long,Long>(Long.valueOf(positions[i][0]),Long.valueOf
                    (positions[i][0]+positions[i][1]));
            for(int j=0;j<i;j++){
                if(interval[j].getKey().compareTo(Long.valueOf(positions[i][0]))<0
                        && Long.valueOf(positions[i][0]).compareTo(interval[j].getValue())<0){
                    height[i]=Math.max(height[i],height[j]+positions[i][1]);
                }
            }
        }
        return Arrays.asList(height);
    }

    public static void main(String []args){
        FallingSquare fs=new FallingSquare();
        int [][]intput={{100, 100}, {200, 100}};
        System.out.println(fs.fallingSquares(intput));
    }
}

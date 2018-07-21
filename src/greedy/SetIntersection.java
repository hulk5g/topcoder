package greedy;

import java.util.Arrays;

/**
 * @author ksharma
 */
public class SetIntersection {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[1]==b[1]?a[0]-b[0]:a[1]-b[1]);
        int count=2;
        int max1=intervals[0][1];
        int max2=max1-1;
       /* for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<=m)
        }
*/
        return count;
    }
    public static void main(String []args){
        SetIntersection si=new SetIntersection();
        int [][] input={{8,9},{4,21},{3,19},{5,9},{1,5}};
        System.out.println(si.intersectionSizeTwo(input));
    }
}

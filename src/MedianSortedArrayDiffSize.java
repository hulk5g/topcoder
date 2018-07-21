/**
 * @author ksharma
 */
public class MedianSortedArrayDiffSize {
    public Double findMedian(int[]x,int[] y){
        if(y.length<x.length){
            return findMedian(y,x);
        }
        int low=0;
        int high=x.length;
        while(low<=high){
            int part1=(low+high)/2;
            int part2=(x.length+y.length+1)/2 - part1;
            int maxLeftX=part1!=0?x[part1-1]:Integer.MIN_VALUE;
            int minRightX=part1!=x.length?x[part1]:Integer.MAX_VALUE;
            int maxLeftY=part2!=0?y[part2-1]:Integer.MIN_VALUE;
            int minRightY=part2!=y.length?y[part2]:Integer.MAX_VALUE;

            if(maxLeftX<=minRightY && maxLeftY<=minRightX){
                if((x.length+y.length)%2==0){
                   int max= Math.max(maxLeftX,maxLeftY);
                   int min=Math.min(minRightX,minRightY);
                   double d=((double)max+min)/2;
                   return d;
                }
                return Double.valueOf(Math.max(maxLeftX,maxLeftY));
            }else if(maxLeftX>minRightY){
                high=part1-1;
            }else{
                low=part1+1;
            }
        }
        return Double.valueOf(-1);
    }
    public static void main(String []args){

        int[] arr1={23,26,31,35};
        int[] arr2={3,5,7,9,11,16};
        MedianSortedArrayDiffSize m=new MedianSortedArrayDiffSize();
        System.out.println(m.findMedian(arr1,arr2));
    }
}

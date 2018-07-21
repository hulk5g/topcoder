/**
 * @author ksharma
 */
public class MedianSortedArraySameSize {

    public Double getMedian(int []arr,int start,int end){
        int n=end-start+1;
        if(n%2!=0){
            return Double.valueOf(arr[start+n/2]);
        }
        return Double.valueOf((arr[start+n/2]+arr[start+n/2-1])/2);
    }

    public Double findMedian(int[]arr1,int[]arr2,int start1,int end1,int start2,int end2){
        int n=end1-start1+1;
       if(n<=0){
           return new Double(-1);
       }
       if(n==1) return Double.valueOf((arr1[start1]+arr2[start2])/2);
       if(n==2){
           return Double.valueOf((Math.max(arr1[start1],arr2[start2])+Math.min(arr1[end1],arr2[end2]))/2);
       }
       Double m1=getMedian(arr1,start1,end1);
       Double m2=getMedian(arr2,start2,end2);
       if(m1.compareTo(m2)==0){
           return m1;
       }
       else if(m1.compareTo(m2)<0){
           if(n%2!=0){
               return findMedian(arr1,arr2,start1+n/2,end1,start2,start2+n/2);
           }
           return findMedian(arr1,arr2,start1+n/2-1,end1,start2,start2+n/2);
       }
        if(n%2!=0){
            return findMedian(arr1,arr2,start1,start1+n/2,start2+n/2,end2);
        }
        return findMedian(arr1,arr2,start1,start1+n/2,start2+n/2-1,end2);
    }

    public static void main(String []args){
        int arr1[] = {1, 12, 15, 26, 38};
        int arr2[] = {2, 13, 17, 30, 45};
        MedianSortedArraySameSize m=new MedianSortedArraySameSize();
        System.out.println(m.findMedian(arr1,arr2,0,arr1.length-1,0,arr2.length-1));
    }
}

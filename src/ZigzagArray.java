import java.util.Scanner;
/**
 * Created by ksharma on 4/28/17.
 */
public class ZigzagArray {
    static int minimumDeletions(int[] a){
        int count=0;
        if(a.length<3)
            return 0;
        if(a.length==3 && (isIncreasing(a[0],a[1],a[2]) || isDecreasing(a[0],a[1],a[2])))
            return 1;
       for(int i=0;i<=a.length-3;i++){
            if(isIncreasing(a[i],a[i+1],a[i+2]) || isDecreasing(a[i],a[i+1],a[i+2])){
                count++;
            }
        }

        return count;
    }

    private static boolean isIncreasing(int a1, int a2, int a3) {
        if(a1<a2 && a2<a3)
            return true;
        return false;
    }

    private static boolean isDecreasing(int a1, int a2, int a3) {
        if(a1>a2 && a2>a3)
            return true;
        return false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        // Return the minimum number of elements to delete to make the array zigzag
        int result = minimumDeletions(a);
        System.out.println(result);
    }
}

package Array;

/**
 * @author ksharma
 */
public class ProductArray {

    public int[] productExceptSelf(int[] nums) {

        int []output=new int[nums.length];
        output[0]=1;

        for(int i=1;i<nums.length;i++){
            output[i]=output[i-1]*nums[i-1];
        }
        int right=nums[nums.length-1];
        for(int i=nums.length-2;i>=0;i--){
            output[i]=output[i]*right;
            right=right*nums[i];
        }
        return output;
    }
    public static void main(String []args){
        ProductArray pa=new ProductArray();
        int[]result=pa.productExceptSelf(new int[]{1,2,3,4});
        for(int a:result){
            System.out.print(a+",");
        }
    }
}

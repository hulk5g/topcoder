package Array;

/**
 * @author ksharma
 */
public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        int i=0;
        int j=1;
        if(nums==null) return j;
        while(i<nums.length){
            if(nums[i]!=i && nums[i]>=0 && nums[i] <nums.length){
                int temp=nums[nums[i]];
                nums[nums[i]]=nums[i];
                nums[i]=temp;
            }else{
                i++;
            }
        }

        for(;j<nums.length;j++){
            if(j!=nums[j]){
                return j;
            }
        }
        return j;
    }

    public static void main(String []args){
        FirstMissingPositive fm=new FirstMissingPositive();
        int []nums={1,2};
        System.out.println(fm.firstMissingPositive(nums));
    }
}

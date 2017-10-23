package hash;

/**
 * Created by wangruofan on 2017/8/9.
 */
public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0){
            return 0;
        }

        int end = 0;
        for(int i = 0; i < nums.length; i ++){
            if(nums[i] != nums[end]){
                end = end + 1;
                nums[end] = nums[i];
            }
        }
        return end + 1;
    }


}

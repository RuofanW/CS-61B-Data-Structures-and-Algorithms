/**
 * Created by wangruofan on 2017/8/8.
 */
public class searchInsert {
    /**
     * param A : an integer sorted array
     * param target :  an integer to be inserted
     * return : an integer
     */
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0){
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;
        int mid;

        while (start + 1 < end){
            mid = start + (end - start) / 2;
            if(nums[mid] == target){
                end = mid;
            }
            else if(nums[mid] < target){
                start = mid;
            }
            else{
                end = mid;
            }
        }

        if (nums[start] >= target){
            return start;
        }
        if (nums[end] >= target){
            return end;
        }
        return nums.length;
    }
}

/**
 * Created by wangruofan on 2017/8/8.
 */
public class searchRange {
    /**
     *@param A : an integer sorted array
     *@param target :  an integer to be inserted
     *return : a list of length 2, [index1, index2]
     */
    public int[] searchRange(int[] A, int target) {
        int[] res = new int[2];
        res[0] = binarySearchfirst(A, target);
        res[1] = binarySearchlast(A, target);
        return res;
    }

    public int binarySearchfirst(int[] nums, int target) {
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

        if (nums[start] == target){
            return start;
        }
        if (nums[end] == target){
            return end;
        }
        return -1;
    }

    public int binarySearchlast(int[] nums, int target) {
        if (nums.length == 0){
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;
        int mid;

        while (start + 1 < end){
            mid = start + (end - start) / 2;
            if(nums[mid] == target){
                start = mid;
            }
            else if(nums[mid] < target){
                start = mid;
            }
            else{
                end = mid;
            }
        }

        if (nums[end] == target){
            return end;
        }
        if (nums[start] == target){
            return start;
        }
        return -1;
    }
}

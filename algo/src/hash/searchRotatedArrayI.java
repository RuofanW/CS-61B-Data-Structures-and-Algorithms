package hash;

/**
 * Created by wangruofan on 2017/8/9.
 */
public class searchRotatedArrayI {
    /**
     *@param nums : an integer rotated sorted array
     *@param target :  an integer to be searched
     *return : an integer
     */
    public int search(int[] nums, int target) {
        if (nums.length == 0){
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;
        int mid;

        while (start + 1 < end){
            mid = start + (end - start) / 2;
            if(nums[mid] > nums[start]){
                if(nums[mid] >= target && target >= nums[start]){
                    end = mid;
                }
                else{
                    start = mid;
                }
            }
            else{
                if(nums[mid] <= target && target <= nums[end]){
                    start = mid;
                }
                else{
                    end = mid;
                }
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

    public static void main(String[] args){
        int[] A = new int[3];
        A[0] = 1;
        A[1] = 2;
        A[2] = 3;
        searchRotatedArrayI test = new searchRotatedArrayI();
        System.out.print(test.search(A, 1 ));
    }

}

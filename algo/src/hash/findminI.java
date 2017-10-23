package hash;

/**
 * Created by wangruofan on 2017/8/9.
 */
public class findminI {
    /**
     * @param nums: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] nums) {
        if (nums.length == 0){
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;
        int mid;

        while (start + 1 < end){
            mid = start + (end - start) / 2;
            if(nums[mid] < nums[end]){
                end = mid;
            }
            else{
                start = mid;
            }
        }

        if (nums[start] > nums[end]){
            return nums[end];
        }
        if (nums[end] > nums[start]){
            return nums[start];
        }
        return -1;

    }

    public static void main(String[] args){
        int[] A = new int[3];
        A[0] = 1;
        A[1] = 2;
        A[2] = 3;
        findminI test = new findminI();
        System.out.print(test.findMin(A));
    }
}

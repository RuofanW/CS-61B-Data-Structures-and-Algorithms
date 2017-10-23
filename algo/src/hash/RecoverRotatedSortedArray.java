package hash;
import java.util.List;
/**
 * Created by wangruofan on 2017/8/9.
 */
public class RecoverRotatedSortedArray {
    public void recoverRotatedSortedArray(List<Integer> nums) {
        // write your code here
        int minindex = findMin(nums);
        reverse(nums, 0, minindex - 1);
        reverse(nums, minindex, nums.size() - 1);
        reverse(nums, 0, nums.size()- 1);
    }
    public void reverse(List<Integer> nums, int start, int end){
        int i = start;
        int j = end;
        while(i < j){
            Integer temp = nums.get(i);
            nums.set(i, nums.get(j));
            nums.set(j, temp);
            i ++;
            j --;
        }
    }
    public int findMin(List<Integer> nums) {
        if (nums.size() == 0){
            return -1;
        }

        int start = 0;
        int end = nums.size() - 1;
        int mid;

        while (start + 1 < end){
            mid = start + (end - start) / 2;
            if(nums.get(mid) < nums.get(end)){
                end = mid;
            }
            else{
                start = mid;
            }
        }

        if (nums.get(start) >= nums.get(end)){
            return end;
        }
        if (nums.get(end) > nums.get(start)){
            return start;
        }
        return -1;

    }
}

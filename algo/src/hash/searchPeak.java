package hash;

/**
 * Created by wangruofan on 2017/8/9.
 */
public class searchPeak {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
        if (A.length == 0){
            return -1;
        }
        int start = 1;
        int end = A.length - 2;
        int mid;
        while(start + 1 < end){
            mid = start + (end - start) / 2;
            if(A[mid] > A[mid + 1] && A [mid - 1] < A[mid]){
                return mid;
            }
            if(A[mid] < A[mid + 1] && A [mid - 1] < A[mid]){
                start = mid;
            }
            if(A[mid] < A[mid + 1] && A [mid - 1] > A[mid]){
                start = mid;
            }
            if(A[mid] > A[mid + 1] && A [mid - 1] > A[mid]){
                end = mid;
            }
        }
        if(A[start - 1] < A[start] && A[start] > A[start + 1]){
            return start;
        }
        if(A[end - 1] < A[end] && A[end] > A[end + 1]){
            return end;
        }
        return -1;
        // write your code here
    }
}

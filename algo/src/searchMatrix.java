/**
 * Created by wangruofan on 2017/8/8.
 */
public class searchMatrix {
    /**
     * @param matrix, a list of lists of integers
     * @param target, an integer
     * @return a boolean, indicate whether matrix contains target
     */


    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
        int[] col = new int[matrix.length];
        for(int i = 0; i < matrix.length; i ++){
            col[i] = matrix[i][0];
        }
        int rowindex = findrow(col, target);
        if (rowindex < 0){
            return false;
        }
        int[] row = new int[matrix[0].length];
        for(int i = 0; i < matrix[0].length; i ++){
            row[i] = matrix[rowindex][i];
        }
        int colindex = findcol(row, target);
        return colindex >= 0;
    }

    public int findrow(int[] nums, int target) {
        if (nums.length == 0){
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;
        int mid;

        while (start + 1 < end){
            mid = start + (end - start) / 2;
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid] < target){
                start = mid;
            }
            else{
                end = mid;
            }
        }

        if (nums[end] <= target){
            return end;
        }
        if (nums[start] <= target){
            return start;
        }
        return -1;

    }

    public int findcol(int[] nums, int target) {
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

    public static void main(String[] args){
        searchMatrix test = new searchMatrix();
        int[][] m = new int[4][4];
        for (int i = 0; i < 4; i ++){
            for (int j = 0; j < 4; j ++){
                m[i][j] = 4 * i + j;
            }
        }
        boolean res = test.searchMatrix(m, 0);
        System.out.print(res);
    }
}

/**
 * Created by wangruofan on 2017/8/12.
 */
public class validateBST {

    public class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }
    public class ResultType {
        int max;
        int min;
        boolean isBST;
        public ResultType(int max, int min, boolean is){
            max = max;
            min = min;
            isBST = is;
        }
    }
    public ResultType helper(TreeNode root){
        // write your code here
        if (root == null){
            return new ResultType(Integer.MAX_VALUE, Integer.MIN_VALUE, true);
        }
        if (root.left == null && root.right == null){
            return new ResultType(root.val, root.val, true);
        }
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        if (!left.isBST || !right.isBST){
            return new ResultType(0, 0, false);
        }
        boolean judge;
        if (root.left != null && root.right != null){
            if (left.max < root.val && right.min > root.val){
                judge = true;
            }
            else{
                judge = false;
            }
        }
        else if (root.left != null){
            judge = root.val > left.max;
        }
        else {
            judge = root.val < right.min;
        }
        int newmax = Math.max(left.max, right.max);
        int newmin = Math.min(left.min, right.min);
        return new ResultType(newmax, newmin, judge);
    }
    public boolean isValidBST(TreeNode root) {
        return helper(root).isBST;
    }

    public static void main(String[] args){
        validateBST test = new validateBST();
        TreeNode root;
        root.val = 1;

    }

}

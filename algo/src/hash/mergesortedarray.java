package hash;

/**
 * Created by wangruofan on 2017/8/9.
 */
public class mergesortedarray {
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        // write your code here
        int len = m + n;
        while(len != 0){
            if(m == 0){
                for(int i = 0; i < n; i ++){
                    A[i] = B[i];
                    len --;
                }
            }
            else if(n == 0){
                len = 0;
            }
            else if(A[m - 1] > B[n - 1]){
                A[len - 1] = A[m - 1];
                m --;
                len --;
            }
            else if(A[m - 1] < B[n - 1]){
                A[len - 1] = B[n - 1];
                n --;
                len --;
            }
        }
    }
    public static void main(String[] args){
        int[] A = new int[10];
        A[0] = 1;
        A[1] = 2;
        A[2] = 3;
        int[] B = new int[2];
        B[0] = 4;
        B[1] = 5;
        mergesortedarray test = new mergesortedarray();
        test.mergeSortedArray(A,3,B,2);
    }
}

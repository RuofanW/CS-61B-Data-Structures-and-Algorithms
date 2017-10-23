package hash;

/**
 * Created by wangruofan on 2017/8/9.
 */
public class rotateString {
    public void rotateString(char[] str, int offset) {
        // write your code here
        if(str.length == 0){
            return;
        }
        reverse(str, 0, str.length - 1);
        reverse(str, 0, offset % str.length - 1);
        reverse(str, offset % str.length, str.length - 1);
    }
    public void reverse(char[] str, int start, int end){
        while(start < end){
            char temp = str[start];
            str[start] = str[end];
            str[end] = temp;
            start ++;
            end --;
        }
    }
}

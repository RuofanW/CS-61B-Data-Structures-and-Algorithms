/**
 * Created by wangruofan on 2017/5/2.
 */
public class OffByOne implements CharacterComparator{
    public boolean equalChars(char x, char y){
        boolean res = false;
        if(x - y == 1 || x - y == -1){
            res = true;
        }
        return res;
    }
}

/**
 * Created by wangruofan on 2017/5/2.
 */
public class OffByN implements CharacterComparator{

    private int N;

    public OffByN (int n){
        N = n;
    }
    @Override
    public boolean equalChars(char x, char y){
        boolean res = false;
        if(x - y == N || x - y == -N){
            res = true;
        }
        return res;
    }
}

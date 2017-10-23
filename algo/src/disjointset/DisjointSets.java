package disjointset;

/**
 * Created by wangruofan on 2017/6/12.
 */
public interface DisjointSets {

    void connect(int p, int q);
    boolean isconnected(int p, int q);
}

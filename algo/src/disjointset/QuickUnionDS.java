package disjointset;

/**
 * Created by wangruofan on 2017/6/12.
 */
public class QuickUnionDS implements DisjointSets{

    private int[] parent;

    public QuickUnionDS(int N){
        parent = new int[N];
        for(int i = 0; i < N; i ++){
            parent[i] = i;
        }
    }

    public int findroot(int p){
        while(p != parent[p]){
            p = parent[p];
        }
        return p;
    }

    public boolean isconnected(int p, int q){
        boolean res = findroot(p) == findroot(q);
        return res;
    }

    public void connect(int p, int q){
        if(findroot(p) == findroot(q)){
            return;
        }
        int proot = findroot(p);
        int qroot = findroot(q);
        parent[proot] = qroot;
    }
}

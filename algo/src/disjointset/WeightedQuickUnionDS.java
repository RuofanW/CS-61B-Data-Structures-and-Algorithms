package disjointset;

/**
 * Created by wangruofan on 2017/6/12.
 */
public class WeightedQuickUnionDS implements DisjointSets{
    private int[] parent;
    private int[] size;

    public WeightedQuickUnionDS(int N){
        parent = new int[N];
        for(int i = 0; i < N; i ++){
            parent[i] = i;
            size[i] = 1;
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
        int proot = findroot(p);
        int qroot = findroot(q);
        if(proot == qroot){
            return;
        }
        else if(size[p] < size[q]){
            parent[proot] = qroot;
            size[qroot] = size[qroot] + size[proot];
        }
        else if(size[p] >= size[q]){
            parent[qroot] = proot;
            size[proot] = size[qroot] + size[proot];
        }
    }
}

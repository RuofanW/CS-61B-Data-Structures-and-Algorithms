package disjointset;

/**
 * Created by wangruofan on 2017/6/12.
 */
public class QuickFindDS implements DisjointSets{

    private int[] id;

    public QuickFindDS(int N){
        id = new int[N];
        for(int i = 0; i < N; i ++){
            id[i] = i;
        }
    }
    public boolean isconnected(int p, int q){
        boolean res = id[p] == id[q];
        return res;
    }

    public void connect(int p, int q){
        int pid = id[p];
        int qid = id[q];
        for(int i = 0; i < id.length; i ++){
            if(id[i] == pid){
                id[i] = qid;
            }
        }
    }
}

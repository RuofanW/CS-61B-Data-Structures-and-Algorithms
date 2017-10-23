/**
 * Created by wangruofan on 2017/5/6.
 */
public class IntList {
    public  int head;
    public  IntList tail;

    public IntList(int h, IntList t){
        head = h;
        tail = t;
    }

    public int size(){
        if(tail == null){
            return 1;
        }
        return 1 + tail.size();
    }

    public int iterativeSize(){
        int res = 0;
        IntList p = this;
        while(p != null){
            res = res + 1;
            p = p.tail;
        }
        return res;
    }

    public int get(int i){
        if(i == 0){
            return head;
        }
        return tail.get( i-1 );
    }

    public void swapTwo() {
        // [1, 2, 3, 4, 5, 6]
        // [2, 1, 4, 3, 6, 5]
        // First we swap the front two,
        // skip 2 and swap the rest.
        IntList L = this;
        int frontvalue = L.head;
        int nextfrontval = L.tail.head;
        L.head = nextfrontval;
        L.tail.head = frontvalue;
        if(L.tail.tail != null){
            L.tail.tail.swapTwo();
        }
    }

    private void change2(int i, int j){
        IntList p = this;
        int ivalue = p.get(i);
        int jvalue = p.get(j);
        for(int k = 0; k < i; k ++){
            p = p.tail;
        }
        p.head = jvalue;
        for(int k = i; k < j; k ++){
            p = p.tail;
        }
        p.head = ivalue;
        for(int k = j; k < this.size(); k ++) {
            p = p.tail;
        }


    }

    private void reverseN(int N) {
        // reverses the front N items of a list
        // [1, 2, 3, 4, 5, 6], 3 --> [3, 2, 1, 4, 5, 6]
        for(int i = 0; i< N/2; i++){
            int temp = this.get(i);
            change2(i, N-1-i);
        }
    }
    public  void printlist(){
        for(int i = 0; i<this.size(); i++){
            System.out.print(this.get(i)+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        IntList L = new IntList(4, null);
        L.tail = new IntList(7, null);
        L.tail.tail = new IntList(8, null);
        L.printlist();

        L.reverseN(3);
        //System.out.println(L.size());
        L.printlist();


    }

}

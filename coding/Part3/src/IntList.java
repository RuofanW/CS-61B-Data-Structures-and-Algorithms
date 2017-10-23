public class IntList {
    public int val;
    public IntList tail;
    public IntList(int val, IntList tail) {
        this.val = val;
        this.tail = tail;
    }
    public void print() {
        System.out.print(val + " ");
        if (tail != null) {
            tail.print();
        }
        System.out.println();
    }
    public IntList strangeInsertFront(int x) {
        this.tail = new IntList(this.val, this.tail);
        this.val = x;
        return this;
    }

    public IntList strangeInsertFront2(int x) {
        IntList p = new IntList(x,null);
        p.tail = this;
        return p;
    }

    public static void main(String[] args) {
        /*
        IntList L = new IntList(4, null);
        L = L.strangeInsertFront(3);
        L = L.strangeInsertFront(2);
        L = L.strangeInsertFront(1);
        IntList L2 = L;
        L = L.strangeInsertFront(0);
        L2 = L2.tail;
        L.tail.strangeInsertFront(0);
        L.print();  // should print 0 1 2 3 4
        L2.print();
        L2.tail.print();// should also print 0 1 2 3 4*/
        IntList egg = new IntList(1,null);
        egg.tail = new IntList(9,null);
        egg.tail.tail = new IntList(2,null);
        egg.tail.tail.tail = new IntList(6,null);
        egg.tail.tail.tail.tail = new IntList(6,null);
        egg.tail.tail.tail.tail.tail = new IntList(4,null);
        IntList backup = egg;
        egg = egg.tail.tail;
        egg.print();
        backup.print();
        for (int i = 0; i < 2; i += 1) {egg.tail = egg.tail.tail;}
        egg.print();
        backup.print();
        egg.tail = new IntList(egg.tail.val - 1, egg.tail);
        egg.print();
        backup.print();
        backup.tail = egg;

        egg.print();
        backup.print();


    }
}

import static org.junit.Assert.*;

import org.junit.Test;

public class IntListTestnew {

    /**
     * Example test that verifies correctness of the IntList.list static
     * method. The main point of this is to convince you that
     * assertEquals knows how to handle IntLists just fine.
     */


    /**
     * Do not use the new keyword in your tests. You can create
     * lists using the handy IntList.list method.
     * <p>
     * Make sure to include test cases involving lists of various sizes
     * on both sides of the operation. That includes the empty list, which
     * can be instantiated, for example, with
     * IntList empty = IntList.list().
     * <p>
     * Keep in mind that dcatenate(A, B) is NOT required to leave A untouched.
     * Anything can happen to A.
     */

    @Test
    public static void main(String args[]) {
        IntList A = IntList.list(1, 2, 3);
        IntList B = IntList.list(4, 5, 6);
        IntList exp = IntList.list(1, 2, 3, 4, 5, 6);
        IntList C = IntList.catenate(A, B);
        if(exp.equals(C)) {
            System.out.println("1");
        }
        System.out.println("0");
    }


    @Test
    public void testDcatenate() {
        IntList A = IntList.list(1, 2, 3);
        IntList B = IntList.list(4, 5, 6);
        IntList exp = IntList.list(1, 2, 3, 4, 5, 6);
        assertEquals(exp, IntList.dcatenate(A, B));
        assertEquals(IntList.list(1, 2, 3, 4, 5, 6), A);
    }

    @Test
    public void testCatenate() {
        IntList A = IntList.list(1, 2, 3);
        IntList B = IntList.list(4, 5, 6);
        IntList exp = IntList.list(1, 2, 3, 4, 5, 6);
        assertEquals(exp, IntList.catenate(A, B));
        assertEquals(IntList.list(1, 2, 3), A);
    }

}

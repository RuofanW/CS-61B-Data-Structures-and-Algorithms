package synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer arb = new ArrayRingBuffer<String>(10);
        arb.enqueue("cat");
        arb.enqueue("dog");
        arb.enqueue("puppy");
        assertEquals(3 ,arb.fillCount());
        assertEquals("cat",arb.dequeue());
        assertEquals("dog",arb.peek());

    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 

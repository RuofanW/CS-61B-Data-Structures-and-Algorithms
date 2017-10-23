import org.junit.Test;
import static org.junit.Assert.*;

public class TestSort {
	@Test
	public void TestSort(){
		String[] totest = new String[]{"cat","bord","damp","apple"};
		String[] expected = new String[]{"apple","bord","cat","damp"};
		String[] actual = Sort.Sort(totest);
		assertArrayEquals(expected, actual);
	}

	@Test
	public void testIndexOfSmallest() {
		String[] inputs = {"milvia", "zero", "josh", "trump"};
		int expected = 2;
		int actual = Sort.indexOfSmallest(inputs, 2);

		assertEquals(expected, actual);

		expected = 3;
		actual = Sort.indexOfSmallest(inputs, 3);
		assertEquals(expected, actual);

	}
	public static void main(String[] args) {
		jh61b.junit.TestRunner.runTests("all", TestSort.class);
	}


} 
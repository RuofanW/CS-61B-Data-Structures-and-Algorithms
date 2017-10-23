import org.junit.Test;
import static org.junit.Assert.*;

public class TestArrayDeque1B{
	public void testaddremove() {
		StudentArrayDeque<Integer> t1 = new StudentArrayDeque<Integer>();
		int[] suiji = new int[5];
		for(int i = 0; i<5; i++){
			suiji[i] = random.nextInt(9);
		}
		t1.addFirst(suiji[0]);
		t1.addFirst(suiji[1]);
		t1.addLast(suiji[2]);
		t1.addLast(suiji[3]);
		AssertEquals("The size is wrong! The current size is" + ti.size, 4, t1.size);
	}

	public static void main(String[] args) {
		testaddremove();
	}

}
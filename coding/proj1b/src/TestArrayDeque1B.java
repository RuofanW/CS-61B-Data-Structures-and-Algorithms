import org.junit.Test;
import static org.junit.Assert.*;

public class TestArrayDeque1B{
	public static void testaddremove() {
		StudentArrayDeque<Integer> t1 = new StudentArrayDeque<Integer>();
		int[] suiji = new int[5];
		for(int i = 0; i<5; i++){
			suiji[i] = StdRandom.uniform(9);
		}
		t1.addFirst(suiji[0]);
		t1.addFirst(suiji[1]);
		t1.addLast(suiji[2]);
		t1.addLast(suiji[3]);
		assertEquals("The size is wrong! The current size is" + t1.size(), 4, t1.size());
		int res1 = t1.removeFirst();
		assertEquals("Removefirst is wrong!", suiji[1], res1);
		assertEquals("The size is wrong! The current size is" + t1.size(), 3, t1.size());
		int res2 = t1.removeLast();
		assertEquals("Removelast is wrong!", suiji[3], res2);
		assertEquals("The size is wrong! The current size is" + t1.size(), 2, t1.size());
		t1.printDeque();
		System.out.println(suiji[0]+" "+suiji[2]);
		t1.removeFirst();
		t1.removeFirst();
		if(t1.isEmpty() == true){
			System.out.println(1);
		}
		t1.removeFirst();
		t1.removeFirst();
		t1.removeFirst();
		t1.removeFirst();
		assertEquals("The size is wrong! The current size is" + t1.size(), 0, t1.size());

	}
	public static  void testget(){
		StudentArrayDeque<Integer> t1 = new StudentArrayDeque<Integer>();
		int[] suiji = new int[5];
		for(int i = 0; i<5; i++){
			suiji[i] = StdRandom.uniform(9);
		}
		t1.addLast(suiji[0]);
		t1.addLast(suiji[1]);
		t1.addLast(suiji[2]);
		t1.addLast(suiji[3]);
		System.out.println("Attention! The correct array is:" +suiji[0]+""+suiji[1]+""+suiji[2]+""+suiji[3]);
		assertEquals("Get Method Wrong!", (Object)suiji[0], t1.get(0));

	}

	public static void main(String[] args) {
		testaddremove();
		testget();
	}

}
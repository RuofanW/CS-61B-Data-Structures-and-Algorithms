public class ArrayBasics {
	public static void main(String[] args) {
		int[] z =null;
		int[] x,y;

		x = new int[]{1,2,3,4,5};
		y = x;
		x = new int[]{-1,2,5,3,2};
		y = new int[3];
		z = new int[0];

		String[] s = new String[2];
		String[] t = new String[6];
        t[4] = "ketchup";
        t[x[3]-x[1]] = "muffin";

		int[] b = {9,1,2,3,2};
		System.arraycopy(x,0,b,0,3);
		s = t;

		System.out.println(b);
		System.out.println(s[2]);
	}
}
public class ArrayBasics2{
	public static void main(String[] args) {
		int[][] pascaltri;
		pascaltri = new int[4][];

		pascaltri[0] = new int[]{1};
		pascaltri[1] = new int[]{1,1};
		pascaltri[2] = new int[]{1,2,1};
		pascaltri[3] = new int[]{1,3,3,1};

		int[][] matrix = new int[4][4];
		System.out.println(matrix);
	}
}
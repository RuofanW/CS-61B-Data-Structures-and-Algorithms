public class Sort {

	/** Returns input strings in sorted order. 
	  * Non-destructive. */

	public static int indexOfSmallest(String[] inputs, int k) {
		int currindex = k;
		for(int i = k+1; i < inputs.length; i++){
			if(inputs[i].compareTo(inputs[currindex]) < 0){
				currindex = i;
			}
		}
		return currindex;
	}

	private static void swap(String[] inputs, int a, int b){
		String temp = inputs[a];
		inputs[a] = inputs[b];
		inputs[b] = temp;
	}

	public static String[] Sort(String[] inputs, int k) {
		if(k == inputs.length){
			return inputs;
		}
		int minDex = indexOfSmallest(inputs, k);
		swap(inputs, minDex, k);
		return Sort(inputs, k+1);
	}

	public static String[] Sort(String[] inputs) {
		return Sort(inputs, 0);
	}

	/** Prints out all strings in inputs. */
	public static void print(String[] inputs) {
	}

	/** Outputs the command line arguments 
	  * in alphabetical order. */
	public static void main(String[] args) {
		
	}
} 
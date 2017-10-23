public class BitonicArraySearch{

	public int[] numbers;
    public int len;
    public int indexofturningpt = -1;

    public BitonicArraySearch(int[] numbers){
    	numbers = numbers;
    	len = numbers.length;
    }

    private boolean binarySearch(int target, int low, int high){
    	int mid = -1;
    	if(numbers[low] == target || numbers[high] == target){
    		return true;
    	}
    	while(low <= high){
    		mid = (low + high) / 2;
    		if(target == numbers[mid]){
    			return true;
    		}
    		else if(target > numbers[mid]){
    			low = mid + 1;
    		}
    		else{
    			high = mid + 1;
    		}
    	}
    	return false;
    }

    private boolean binarySearchReversed(int target, int low, int high){
    	int mid = -1;
    	if(numbers[low] == target || numbers[high] == target){
    		return true;
    	}
    	while(low <= high){
    		mid = (low + high) / 2;
    		if(target == numbers[mid]){
    			return true;
    		}
    		else if(target <numbers[mid]){
    			low = mid + 1;
    		}
    		else{
    			high = mid - 1;
    		}
    	}
    	return false;
    }

    private int binarySearchForTurningPoint(){
    	int low = 1;
    	int high = len-2;
    	int mid = -1;
    	while(low <= high){
    		mid = (low + high) / 2;
    		if(numbers[mid - 1] < numbers[mid] && numbers[mid] > numbers[mid + 1]){
    			return mid;
    		}
    		else if(numbers[mid - 1] < numbers[mid] && numbers[mid] < numbers[mid + 1]){
    			low = mid + 1;
    		}
    		else if(numbers[mid - 1] > numbers[mid] && numbers[mid] > numbers[mid + 1]){
    			high = mid - 1;
    		}
    	}
    	return -1;
    }

    public boolean search(int target){
    	if(indexofturningpt < 0){
    		indexofturningpt = this.binarySearchForTurningPoint();
    	}
    	boolean res1 = this.binarySearchReversed(target, 0, indexofturningpt);
    	boolean res2 = this.binarySearchReversed(target, indexofturningpt + 1, len -1 );
    	if(res1 == true || res2 == true){
    		return true;
    	}
    	return false;
    }

    public static void main(String args[]) {
    	int[] t= new int[]{1,3,5,7,6,4,2};
    	BitonicArraySearch test1 = new BitonicArraySearch(t);
    	System.out.println(test1.search(5));
    }










}

public class MyArray {
	int[] array;

	public MyArray(int[] array) {
		super();
		this.array = array;
	}

	public int iterativeLinearSearch(int target) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == target)
				return i;
		}
		return -1;
	}

	public int recursiveLinearSearch(int target) {
		return recursiveLinearSearchHelp(target, 0);
	}

	public int recursiveLinearSearchHelp(int target, int dex) {
		if (dex < array.length) {
			if (array[dex] == target)
				return dex;
			else
				return recursiveLinearSearchHelp(target, dex + 1);
		}
		return -1;
	}

	public int iterativeBinarySearch(int target) {
		int left = 0;
		int right = array.length - 1;
		while (left < right) {
			int mid = (left + right) / 2;
			if (array[mid] == target)
				return mid;
			if (array[mid] < target)
				left = mid;
			if (array[mid] > target)
				right = mid;
		}
		return -1;
	}
	public int recursiveBinarySearch(int target) {
		return recursiveBinarySearchHelp(target, 0, array.length-1);
	}
	public int recursiveBinarySearchHelp(int target, int left, int right) {
		if (left < right) {
			int mid = (left+right)/2;
			if (array[mid] == target) return mid;
			if (array[mid] < target) return recursiveBinarySearchHelp(target, mid, right);
			if (array[mid]> target) return recursiveBinarySearchHelp(target, left, mid);
		}
		return -1;
	}

	public static void main(String[] args) {
		MyArray as = new MyArray(new int[] { 1, 2, 3, 4, 4, 5 });
		System.out.println(as.recursiveBinarySearch(3));
		
	}
}

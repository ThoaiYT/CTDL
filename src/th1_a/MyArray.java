package th1_a;

import java.util.ArrayList;
import java.util.Arrays;

public class MyArray {
	private int[] array;

	public MyArray(int[] array) {
		this.array = array;
	}

	public int[] mirror() {
		int[] result = new int[array.length * 2];
		for (int i = 0; i < array.length; i++) {
			result[i] = array[i];
			result[result.length - i - 1] = array[i];
		}
		return result;

	}

	public boolean contain(int[] temp, int num) {
		for (int i = 0; i < temp.length; i++) {
			if (temp[i] == num)
				return true;
		}
		return false;
	}

	public boolean chua(int[] arr, int dex) {
		for (int i = 0; i < dex; i++) {
			if (arr[i] == arr[dex])
				return true;
		}
		return false;
	}

	public int[] removeDuplicate_Remix() {
		boolean[] bo = new boolean[array.length];
		bo[0] = false;
		int len = 0;
		for (int i = 1; i < array.length; i++) {
			if (chua(array, i)) {
				len++;
				bo[i] = false;
			} else
				bo[i] = true;
		}
		int[] result = new int[len];
		int dex = 0;
		for (int i = 0; i < array.length; i++) {
			if (bo[i] == false) {
				result[dex] = array[i];
				dex++;

			}
		}
		return result;
	}

	public int[] removeDuplicates() {
		int[] temp = new int[array.length];
		int dex = 0;
		boolean zero = false;

		if (array.length == 0 || array.length == 1)
			return array;

		for (int i = 0; i < array.length; i++) {
			if (array[i] == 0) {
				if (zero == false) {
					temp[dex] = array[i];
					dex++;
					zero = true;
				}
			} else if (!contain(temp, array[i])) {
				temp[dex] = array[i];
				dex++;
			}
		}
		int[] result = new int[dex];
		for (int i = 0; i < result.length; i++) {
			result[i] = temp[i];
		}
		return result;
	}

//	public int[] fillMissingValue(int k) {
//		for (int i = 0; i < array.length; i++) {
//
//			if (array[i] > array[i + 1]) {
//				for (int j = i; j < i - k; j++) {
//					
//				}
//				
//			}
//		}
//	}

	public int[] missing() {
		int[] temp = new int[array.length];
		int dex = 0;
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i] + 1 != array[i + 1]) {
				for (int j = array[i] + 1; j < array[i + 1]; j++) {
					temp[dex] = j;
					dex++;
				}
			}
		}
		int[] result = new int[dex];
		if (result.length == 0)
			return null;
		for (int i = 0; i < dex; i++) {
			result[i] = temp[i];
		}
		return result;
	}

	public void display(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}

	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 0, 3, 3, 0, 10, 11, 9, 3, 4, 9 };

		MyArray a = new MyArray(arr);
		a.display(a.removeDuplicate_Remix());
	}
}

package abc;

import java.util.Arrays;

public class Sortt {
	public static void merge(int arr[], int left, int mid, int right) {
		// 6 4 6 1 3 9
		// 0 1 2 3 4 5
        int len1 = mid - left + 1;
        int len2 = right - mid;
        int leftTemp[] = new int[len1]; //[6,4,6]
        int rightTemp[] = new int[len2];//[1,3,9]
        for (int i = 0; i < len1; ++i)
            leftTemp[i] = arr[left + i];
        for (int j = 0; j < len2; ++j)
            rightTemp[j] = arr[mid + 1 + j];
        int i = 0, j = 0, k = left;

        while (i < len1 && j < len2) {
            if (leftTemp[i] >= rightTemp[j]) {
                arr[k] = leftTemp[i];
                i++;
            } else {
                arr[k] = rightTemp[j];
                j++;
            }
            k++;
        }
        while (i < len1) {
            arr[k] = leftTemp[i];
            i++;
            k++;
        }
        while (j < len2) {
            arr[k] = rightTemp[j];
            j++;
            k++;
        }
    }
	public static void mergeSort(int[] arr) {
		sortHelp(arr, 0, arr.length-1);
	}
    public static void sortHelp(int arr[], int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            sortHelp(arr, left, mid);
            sortHelp(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }
	public static void selectionSort(int[] arr) {
		int n = arr.length;

		for (int i = 0; i < n - 1; i++) {
			int min_idx = i;
			for (int j = i + 1; j < n; j++)
				if (arr[j] < arr[min_idx])
					min_idx = j;

			int temp = arr[min_idx];
			arr[min_idx] = arr[i];
			arr[i] = temp;

		}
	}
	public static void bubbleSort(int[] arr) {

		while (true) {
			boolean stop = true;
			for (int i = 0; i < arr.length - 1; i++) {
				if (arr[i] < arr[i + 1]) {
					int temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
					stop = false;
				}
			}
			if (stop == true)
				break;
		}
	}
	
	private static int partition(int arr[], int begin, int end) {
	    int pivot = arr[end];
	    int i = (begin-1);

	    for (int j = begin; j < end; j++) {
	        if (arr[j] <= pivot) {
	            i++;
	            int swapTemp = arr[i];
	            arr[i] = arr[j];
	            arr[j] = swapTemp;
	        }
	    }

	    int swapTemp = arr[i+1];
	    arr[i+1] = arr[end];
	    arr[end] = swapTemp;

	    return i+1;
	}
	public static void quicksort(int [] arr) {
		quickSortRecusive(arr, 1, arr.length-1);
	}
	public static void quickSortRecusive(int arr[], int begin, int end) {
	    if (begin < end) {
	        int partitionIndex = partition(arr, begin, end);

	        quickSortRecusive(arr, begin, partitionIndex-1);
	        quickSortRecusive(arr, partitionIndex+1, end);
	    }
	}
	public static void insertionSort(int[] arr) {
		int n = arr.length;
		for (int i = 1; i < n; ++i) {
			int key = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] < key) {
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = key;
		}
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2131, 231, 123 };
		mergeSort(arr);
		System.out.println(Arrays.toString(arr));
	}
}

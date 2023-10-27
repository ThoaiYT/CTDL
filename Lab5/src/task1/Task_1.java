package task1;

import java.util.Arrays;
import java.util.Iterator;

public class Task_1 {
	public static boolean checkMatrix(int[][] arr1, int[][] arr2) {
		if (!isMatrix(arr1) || !isMatrix(arr2))
			return false;
		if (arr1.length != arr2.length)
			return false;
		else {
			for (int j = 0; j < arr1.length; j++) {
				if (arr1[j].length != arr2[j].length)
					return false;
			}
		}
		return true;
	}

	public static int[][] add(int[][] arr1, int[][] arr2) {
		if (checkMatrix(arr1, arr2) == false)
			return null;
		int[][] result = new int[arr1.length][arr1[0].length];
		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr1[i].length; j++) {
				result[i][j] = arr1[i][j] + arr2[i][j];
			}
		}
		return result;
	}

	public static boolean isMatrix(int[][] a) {
		if (a.length < 1)
			return false;
		for (int i = 0; i < a.length - 1; i++) {
			if (a[i].length != a[i + 1].length)
				return false;
		}
		return true;
	}

	public static int[][] subtract(int[][] arr1, int[][] arr2) {
		if (checkMatrix(arr1, arr2) == false)
			return null;
		int[][] result = new int[arr1.length][arr1[0].length];
		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr1[i].length; j++) {
				result[i][j] = arr1[i][j] - arr2[i][j];
			}
		}
		return result;

	}

	public static int[][] tranpose(int[][] a) {
		if (!isMatrix(a))
			return null;
		int[][] tranposedMatrix = new int[a[0].length][a.length];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length;j++) {
				tranposedMatrix[j][i]= a[i][j];
			}
		}
		return tranposedMatrix;
	}
	public static void printMatrix(int[][] arr){
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j]+ " ");
			}
			System.out.println();
		}
		System.out.println("---------------------------");
		
	}
	public static void main(String[] args) {
		int[][] arr1 = {{1,2,3},{3,4,5}};
		int[][] arr2 = {{3,1,5},{9,0,-3}};
		printMatrix(add(arr1, arr2));
		printMatrix(subtract(arr1, arr2));
		printMatrix(tranpose(arr2));
		
	}
	
}

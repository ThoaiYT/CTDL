package dequy;


public class drawPyramid {

	    public static void drawPyramid(int n) {
	        drawPyramidRecursive(n, 1);
	    }

	    private static void drawPyramidRecursive(int n, int row) {
	        if (n == 0) {
	            return;
	            
	        }

	        // Print spaces for alignment
	        printSpaces(n - 1);

	        // Print X's for the pyramid
	        printX(row);

	        // Move to the next line
	        System.out.println();

	        // Recursively draw the rest of the pyramid
	        drawPyramidRecursive(n - 1, row + 2);
	    }

	    private static void printSpaces(int count) {
	        if (count > 0) {
	            System.out.print(" ");
	            printSpaces(count - 1);
	        }
	    }

	    private static void printX(int count) {
	        if (count > 0) {
	            System.out.print("X");
	            printX(count - 1);
	        }
	    }

	    public static void main(String[] args) {
	        int n = 4;
	        drawPyramid(n);
	    }
	}

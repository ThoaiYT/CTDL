package dequy;

public class Alabamalalala {
	// S(n)=1-2+3-4+…+ ((-1)^(n+1) ).n , n>0
	public int cau1(int n) {
		if (n == 1)
			return 1;
		return (int) Math.pow(-1, n + 1) * n + cau1(n - 1);
	}

	public String drawPyramid(int n, int row) {
		if (n > 0) {
			return printSpace(n - 1) + printX(row) + "\n" + drawPyramid(n - 1, row + 2);
		}
		return "";
	}

	public String printSpace(int n) {
		if (n > 0)
			return " " + printSpace(n - 1);
		else
			return "";
	}

	public String printX(int n) {
		if (n > 0)
			return "X" + printX(n - 1);
		return "";
	}

	public int cou1(int n) {
		if (n == 0)
			return 0;
		if (n % 2 == 1)
			return cou1(n - 1) + n;
		if (n % 2 == 0)
			return cou1(n - 1) - n;
		return 0;

	}

	public int luythua2(int x) {
		return x * x;
	}

	public int cau3(int n) {
		if (n == 0)
			return 0;
		return luythua2(n) + cau3(n - 1);

	}

	public String generateRow(int n) {
		String str = "";
		for (int i = 0; i < n; i++) {
			str += n + " ";
		}
		return str;
	}
	
	public String intPyramid(int n) {
		if (n > 0) {
			return generateSpace(n) +generateRow(n) + "\n" + intPyramid(n - 1);
		}
		return "";
	}

	public int cau2(int n) {
		if (n == 0)
			return 0;
		return giaithua(n) + cau2(n - 1);
	}

	public int giaithua(int n) {
		if (n == 0)
			return 1;
		return n * giaithua(n - 1);
	}

	public int tinhmau(int n) {
		if (n == 0)
			return 1;
		return 2 * tinhmau(n - 1);
	}

	public int[] regenerateNexRow(int[] prevRow) {
		int[] re = new int[prevRow.length + 1];
		re[0] = re[re.length - 1] = 1;
		for (int i = 1; i < re.length - 1; i++) {
			re[i] = prevRow[i - 1] + prevRow[i];
		}
		return re;
	}

	public int[] getPascalTriangle(int row) {
		if (row == 1)
			return new int[] { 1 };
		if (row == 2)
			return new int[] { 1, 1 };
		if (row == 3)
			return new int[] { 1, 2, 1 };

	}

	public void tgPascal(int n) {

	}

	public double congqqgido(int n) {
		if (n == 0)
			return 1;
		return (double) 1 / tinhmau(n) + (double) 1 / tinhmau(n - 1);

	}

	public static void main(String[] args) {
		Alabamalalala ala = new Alabamalalala();
		// System.out.println(ala.congluythua(4));
		System.out.println(ala.cou1(4));
		// System.out.println(ala.conggiaithua(3));
		// System.out.println(ala.congqqgido(3));
		System.out.println(ala.intPyramid(3));
	}
}

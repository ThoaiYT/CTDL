package th1_a;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class MyCaesar {
	public static final char[] ALPHABET = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
			'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
	private int n;// shift steps (right shift)

	public MyCaesar(int shiftSteps) {
		this.n = shiftSteps;
	}

	// Encrypt a character according to the given shif steps.
	// Encrypt: En(x) = (x + n) mod 26. x represents the index of c in the ALPHABET
	// array
	public char encryptChar(char c) {
		if (c == ' ')
			return ' ';
		char result = 0;
//		for (int i = 0; i < ALPHABET.length; i++) {
//			if (c == ALPHABET[i]) {
//				while (i + n >= 26) {
//					n -= 26;
//				}
//				result = ALPHABET[i + n];
//			}
//		}
		for (int i = 0; i < ALPHABET.length; i++) {
			if (c == ALPHABET[i]) {
				if ((i + n) % 26 >= 26) {
					result = ALPHABET[(i + n) % 26 - 26];
				} else
					result = ALPHABET[(i + n) % 26];
			}
		}
		return result;

	}

	// Encrypt a text using the above function for encrypting a charater.
	public String encrypt(String input) {
		String result = "";
		for (int i = 0; i < input.length(); i++) {
			result += encryptChar(input.charAt(i));
		}
		return result;
	}

	// Decrypt a character according to the given shif steps.
	// Decrypt: Dn(x) = (x – n) mod 26. x represents the index of c in the ALPHABET
	// array
	public char decryptChar(char c) {
		if (c == ' ')
			return ' ';
		char result = 0;
		for (int i = 0; i < ALPHABET.length; i++) {
			if (c == ALPHABET[i]) {
				if ((i - n) % 26 < 0) {
					result = ALPHABET[(i - n) % 26 + 26];
				} else
					result = ALPHABET[(i - n) % 26];
			}
		}
		return result;
	}

	public String decrypt(String input) {
		String result = "";
		for (int i = 0; i < input.length(); i++) {
			result += decryptChar(input.charAt(i));
		}
		return result;
	}

	// Encrypt a encrypted the text content in the srcfile and save it into desFile.
	public void encrypt(String srcFile, String desFile) throws IOException, FileNotFoundException {
		BufferedReader reader = new BufferedReader(new FileReader(srcFile));
		PrintWriter writer = new PrintWriter(desFile);
		String line = null;
		while (true) {
			line = reader.readLine();

			if (line == null)
				break;
			line = encrypt(line);
			writer.println(line);
			// System.out.println(line);
		}
		reader.close();
		writer.close();

	}

	// Decrypt a encrypted the text content in the srcfile and save it into desFile.
	public void decrypt(String srcFile, String desFile) throws IOException, FileNotFoundException {
		BufferedReader reader = new BufferedReader(new FileReader(srcFile));
		PrintWriter writer = new PrintWriter(desFile);
		String line = null;
		while (true) {
			line = reader.readLine();

			if (line == null)
				break;
			line = decrypt(line);
			writer.println(line);
			// System.out.println(line);
		}
		reader.close();
		writer.close();
	}

	public static void main(String[] args) {
		MyCaesar cs = new MyCaesar(3);
		System.out.println(cs.encryptChar('G'));
		System.out.println(cs.encrypt("DMM THANG LOZ VINH"));
		System.out.println(cs.decryptChar('A'));
		System.out.println(cs.decrypt("GPP WKDQJ ORC YLQK"));
		try {
			cs.encrypt("C:/Users/Admin/Downloads/abc/a.txt", "C:/Users/Admin/Downloads/abc/b.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}

package Task2;

import java.util.Arrays;

public class TicTacToe {
	private static final char EMPTY = ' '; 
	private static final char X = 'X';
	private static final char O = 'O';
	private char[][] board;

	public TicTacToe(char[][] board) {
		super();
		this.board = board;
	}

	public boolean checkRows() {
		for (int i = 0; i < board.length; i++) {
			boolean thisRow = true;
			for (int j = 0; j < board[i].length - 1; j++) {
				if (board[i][j] == EMPTY || board[i][j] != board[i][j + 1])
					thisRow = false;
			}
			if (thisRow == true)
				return true;
		}
		return false;
	}

	public boolean checkColumns() {
		for (int i = 0; i < board[0].length; i++) {
			boolean thisRow = true;
			for (int j = 0; j < board.length - 1; j++) {
				if (board[j][i] == EMPTY || board[j][i] != board[j + 1][i])
					thisRow = false;
			}
			if (thisRow == true)
				return true;
		}
		return false;
	}

	public boolean checkDiagonals() {
		boolean result = true;
		for (int i = 0; i < board.length - 1; i++) {

			if (board[i][i] == EMPTY || board[i][i] != board[i + 1][i + 1])
				result = false;
		}
		if (result == true)
			return true;
		else {
			result = true;
			int len = board.length - 1;
			for (int i = 0; i < board.length - 1; i++) {

				if (board[i][len - i] == EMPTY || board[i][len - i] != board[i + 1][len - i - 1])
					result = false;
			}
			if (result == true)
				return true;
			return false;
		}
	}

	public static void main(String[] args) {
		
	}
}

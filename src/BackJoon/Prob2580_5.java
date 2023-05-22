package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Prob2580_5 {

	static int[][] board = new int[9][9];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		sudoku(0, 0);
	}

	private static boolean sudoku(int row, int col) {

		if (col == 9) {
			return sudoku(row + 1, 0);
		}

		if (row == 9) {
			printBoard();
			return true;
		}

		if (board[row][col] == 0) {
			for (int num = 1; num <= 9; num++) {
				if (isPossible(row, col, num)) {
					board[row][col] = num;
					if (sudoku(row, col + 1)) {
						return true;
					}
					board[row][col] = 0;
				}
			}
			return false;
		} else {
			return sudoku(row, col + 1);
		}
	}

	private static boolean isPossible(int row, int col, int num) {

		int rowStart = (row / 3) * 3;
		int colStart = (col / 3) * 3;

		for (int i = 0; i < 9; i++) {
			if (board[row][i] == num || board[i][col] == num || board[rowStart + (i / 3)][colStart + (i % 3)] == num) {
				return false;
			}
		}

		return true;
	}

	private static void printBoard() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				sb.append(board[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prob2630 {

	static int[][] board;
	static int white = 0;
	static int blue = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		board = new int[n][n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		quadrant(0, 0, n);

		System.out.println(white);
		System.out.println(blue);
	}

	private static void quadrant(int row, int col, int size) {

		if (isSame(row, col, size)) {
			if (board[row][col] == 0) {
				white++;
				return;
			} else {
				blue++;
				return;
			}
		}
		int newSize = size / 2;

		quadrant(row, col, newSize);
		quadrant(row, col + newSize, newSize);
		quadrant(row + newSize, col, newSize);
		quadrant(row + newSize, col + newSize, newSize);
	}

	private static boolean isSame(int row, int col, int size) {

		int color = board[row][col];

		for (int i = row; i < row + size; i++) {
			for (int j = col; j < col + size; j++) {
				if (board[i][j] != color) {
					return false;
				}
			}
		}

		return true;
	}
}

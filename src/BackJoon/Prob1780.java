package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prob1780 {

	static int[][] paper;
	static int[] count = new int[3];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		paper = new int[n][n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		divide(0, 0, n);

		for (int i = 0; i < 3; i++) {
			System.out.println(count[i]);
		}
	}

	private static void divide(int row, int col, int size) {

		if (isSame(row, col, size)) {
			count[paper[row][col] + 1]++;
			return;
		}

		int newSize = size / 3;

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				divide(row + newSize * i, col + newSize * j, newSize);
			}
		}
	}

	private static boolean isSame(int row, int col, int size) {

		int color = paper[row][col];

		for (int i = row; i < row + size; i++) {
			for (int j = col; j < col + size; j++) {
				if (paper[i][j] != color) {
					return false;
				}
			}
		}

		return true;
	}
}

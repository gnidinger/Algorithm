package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prob1992 {

	static int[][] video;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		video = new int[n][n];

		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < n; j++) {
				video[i][j] = str.charAt(j) - '0';
			}
		}

		quadrant(0, 0, n);
		System.out.println(sb.toString());
	}

	private static void quadrant(int row, int col, int size) {

		if (isSame(row, col, size)) {
			sb.append(video[row][col]);
			return;
		}

		int newSize = size / 2;
		sb.append("(");
		quadrant(row, col, newSize);
		quadrant(row, col + newSize, newSize);
		quadrant(row + newSize, col, newSize);
		quadrant(row + newSize, col + newSize, newSize);
		sb.append(")");
	}

	private static boolean isSame(int row, int col, int size) {

		int color = video[row][col];

		for (int i = row; i < row + size; i++) {
			for (int j = col; j < col + size; j++) {
				if (video[i][j] != color) {
					return false;
				}
			}
		}

		return true;
	}
}

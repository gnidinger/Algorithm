package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Prob2447_2 {

	static char[][] result;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		result = new char[n][n];
		for (char[] row : result) {
			Arrays.fill(row, ' ');
		}

		star(n, 0, 0);

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				sb.append(result[i][j]);
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}

	public static void star(int n, int x, int y) {

		if (n == 1) {
			result[y][x] = '*';
			return;
		}

		int m = n / 3;
		for (int dy = 0; dy < 3; dy++) {
			for (int dx = 0; dx < 3; dx++) {
				if (dx == 1 && dy == 1) {
					continue;
				}
				star(m, x + m * dx, y + m * dy);
			}
		}
	}
}

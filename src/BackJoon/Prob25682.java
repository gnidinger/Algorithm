package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prob25682 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		char[][] board = new char[n][m];
		for (int i = 0; i < n; i++) {
			board[i] = br.readLine().toCharArray();
		}

		int[][] sum = new int[n + 1][m + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1];
				if ((i + j) % 2 == 0 && board[i - 1][j - 1] == 'B') {
					sum[i][j]++;
				} else if ((i + j) % 2 == 1 && board[i - 1][j - 1] == 'W') {
					sum[i][j]++;
				}
			}
		}

		int result = n * m;

		for (int i = k; i <= n; i++) {
			for (int j = k; j <= m; j++) {
				int black = sum[i][j] - sum[i - k][j] - sum[i][j - k] + sum[i - k][j - k];
				int white = k * k - black;
				result = Math.min(result, Math.min(black, white));
			}
		}

		System.out.println(result);
	}
}

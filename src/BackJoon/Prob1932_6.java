package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Prob1932_6 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[][] arr = new int[n][n];
		int[][] memo = new int[n][n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j <= i; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		memo[0][0] = arr[0][0];

		for (int i = 1; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				if (j == 0) {
					memo[i][j] = memo[i - 1][j] + arr[i][j];
				} else if (j == i) {
					memo[i][j] = memo[i - 1][j - 1] + arr[i][j];
				} else {
					memo[i][j] = Math.max(memo[i - 1][j], memo[i - 1][j - 1]) + arr[i][j];
				}
			}
		}
		System.out.println(Arrays.stream(memo[n - 1]).max().getAsInt());
	}
}

package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class prob11049 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][2];
		int[][] dp = new int[n][n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < n - i; j++) {
				int k = i + j;
				dp[j][k] = Integer.MAX_VALUE;

				for (int l = j; l < k; l++) {
					int cost = dp[j][l] + dp[l + 1][k] + arr[j][0] * arr[l][1] * arr[k][1];
					dp[j][k] = Math.min(dp[j][k], cost);
				}
			}
		}

		System.out.println(dp[0][n - 1]);
	}
}

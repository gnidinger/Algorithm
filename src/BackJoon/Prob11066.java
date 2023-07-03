package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prob11066 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		while (t > 0) {

			int k = Integer.parseInt(br.readLine());
			int[] files = new int[k + 1];
			int[][] dp = new int[k + 1][k + 1];
			int[] s = new int[k + 1];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= k; i++) {
				files[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 1; i <= k; i++) {
				s[i] = s[i - 1] + files[i];
			}

			for (int i = 2; i <= k; i++) {
				for (int j = 1; j <= k - i + 1; j++) {

					int m = i + j - 1;
					dp[j][m] = Integer.MAX_VALUE;

					for (int x = j; x < m; x++) {
						int cost = dp[j][x] + dp[x + 1][m] + s[m] - s[j - 1];
						dp[j][m] = Math.min(dp[j][m], cost);
					}
				}
			}

			System.out.println(dp[1][k]);

			t--;
		}
	}
}

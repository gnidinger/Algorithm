package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prob2629 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] weights = new int[31];
		boolean[][] dp = new boolean[31][40001];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			weights[i] = Integer.parseInt(st.nextToken());
		}

		dp[0][0] = true;
		dp[0][weights[0]] = true;

		for (int i = 1; i < n; i++) {
			for (int j = 0; j <= 40000; j++) {
				if (dp[i - 1][j]) {
					dp[i][j] = true;
					dp[i][j + weights[i]] = true;
					dp[i][Math.abs(j - weights[i])] = true;
				}
			}
		}

		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < m; i++) {
			int marble = Integer.parseInt(st.nextToken());

			if (marble > 40000 || !dp[n - 1][marble]) {
				sb.append('N').append(' ');
			} else {
				sb.append('Y').append(' ');
			}
		}

		System.out.println(sb);
	}
}

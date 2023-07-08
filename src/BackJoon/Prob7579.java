package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Prob7579 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] memories = new int[n + 1];
		int[] costs = new int[n + 1];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= n; i++) {
			memories[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= n; i++) {
			costs[i] = Integer.parseInt(st.nextToken());
		}

		int sumCost = 0;
		for (int cost : costs) {
			sumCost += cost;
		}

		int[] dp = new int[sumCost + 1];
		Arrays.fill(dp, Integer.MIN_VALUE);
		dp[0] = 0;

		for (int i = 1; i <= n; i++) {
			for (int j = sumCost; j >= costs[i]; j--) {
				dp[j] = Math.max(dp[j], dp[j - costs[i]] + memories[i]);
			}
		}

		int result = 0;
		for (int i = 0; i <= sumCost; i++) {
			if (dp[i] >= m) {
				result = i;
				break;
			}
		}

		System.out.println(result);
	}
}

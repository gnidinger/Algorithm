package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prob9461_3 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			long[] memo = new long[n + 2];

			System.out.println(bottomUp(n, memo));
		}
	}

	private static long bottomUp(int n, long[] memo) {

		memo[0] = 0;
		memo[1] = 1;
		memo[2] = 1;

		for (int i = 3; i <= n; i++) {
			memo[i] = memo[i - 2] + memo[i - 3];
		}

		return memo[n];
	}
}

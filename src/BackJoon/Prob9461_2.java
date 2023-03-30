package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prob9461_2 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			long result = bottomUp(n);
			sb.append(result).append('\n');
		}
		System.out.println(sb);
	}

	static long bottomUp(int n) {

		long[] memo = new long[n + 3];

		memo[0] = 1;
		memo[1] = 1;
		memo[2] = 1;
		memo[3] = 1;

		for (int i = 4; i <= n; i++) {
			memo[i] = memo[i - 2] + memo[i - 3];
		}

		return memo[n];
	}
}

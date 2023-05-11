package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prob2156_2 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] wine = new int[n + 1];
		int[] memo = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			wine[i] = Integer.parseInt(br.readLine());
		}

		memo[1] = wine[1];

		if (n >= 2) {
			memo[2] = memo[1] + wine[2];
		}

		for (int i = 3; i <= n; i++) {
			memo[i] = Math.max(memo[i - 1], Math.max(memo[i - 2] + wine[i], memo[i - 3] + wine[i - 1] + wine[i]));
		}

		System.out.println(memo[n]);
	}
}
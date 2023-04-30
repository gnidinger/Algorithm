package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prob1463_4 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] memo = new int[n + 1];

		for (int i = 2; i <= n; i++) {
			memo[i] = memo[i - 1] + 1;

			if (i % 3 == 0) {
				memo[i] = Math.min(memo[i], memo[i / 3] + 1);
			}

			if (i % 2 == 0) {
				memo[i] = Math.min(memo[i], memo[i / 2] + 1);
			}
		}
		System.out.println(memo[n]);
	}
}

package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prob2156_3 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] wines = new int[n + 1];
		int[] memo = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			wines[i] = Integer.parseInt(br.readLine());
		}

		memo[1] = wines[1];


		if (n >= 2) {
			memo[2] = memo[1] + wines[2];
		}

		for (int i = 3; i <= n; i++) {
			memo[i] = Math.max(memo[i - 1], Math.max(memo[i - 2] + wines[i], memo[i - 3] + wines[i - 1] + wines[i]));
		}

		System.out.println(memo[n]);
	}
}
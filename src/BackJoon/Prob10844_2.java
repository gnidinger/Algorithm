package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prob10844_2 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int mod = 1_000_000_000;
		int result = 0;
		int[][] memo = new int[n + 1][10];

		for (int i = 1; i < 10; i++) {
			memo[1][i] = 1;
		}

		for (int i = 2; i <= n; i++) {
			for (int j = 0; j <= 9; j++) {

				if (j == 0) {
					memo[i][0] = memo[i - 1][1] % mod;
				} else if (j == 9) {
					memo[i][9] = memo[i - 1][8] % mod;
				} else {
					memo[i][j] = (memo[i - 1][j - 1] + memo[i - 1][j + 1]) % mod;
				}
			}
		}
		for (int i = 0; i <= 9; i++) {
			result = (result + memo[n][i]) % mod;
		}
		System.out.println(result);
	}
}

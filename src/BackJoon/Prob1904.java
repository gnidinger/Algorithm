package BackJoon;

import java.util.Scanner;

public class Prob1904 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		System.out.println(bottomUp(n));
	}

	private static long bottomUp(int n) {

		long[] memo = new long[n + 1];
		memo[0] = 1;
		memo[1] = 1;

		for (int i = 2; i <= n; i++) {
			memo[i] = (memo[i - 1] + memo[i - 2]) % 15746;
		}

		return memo[n];
	}
}
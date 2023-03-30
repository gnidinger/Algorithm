package BackJoon;

import java.util.Scanner;

public class Prob11051 {

	private static int[][] memo;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int r = sc.nextInt();
		memo = new int[n + 1][r + 1];

		System.out.println(combination(n, r));
	}

	static int combination(int n, int r) {

		if (memo[n][r] != 0) {
			return memo[n][r];
		}

		if (n == r || r == 0) {
			return memo[n][r] = 1;
		}

		memo[n][r] = (combination(n - 1, r) + combination(n - 1, r - 1)) % 10007;

		return memo[n][r];
	}
}
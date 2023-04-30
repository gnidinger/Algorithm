package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prob24416_2 {

	private static int recursionCount = 0;
	private static int dpCount = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		fibRecursion(n);
		fibDp(n);

		System.out.println(recursionCount + " " + dpCount);
	}

	private static int fibRecursion(int n) {

		if (n == 1 || n == 2) {
			recursionCount++;
			return 1;
		} else {
			return fibRecursion(n - 1) + fibRecursion(n - 2);
		}
	}

	private static int fibDp(int n) {

		int[] memo = new int[n + 1];
		memo[1] = 1;
		memo[2] = 1;

		for (int i = 3; i <= n; i++) {
			dpCount++;
			memo[i] = memo[i - 1] + memo[i - 2];
		}

		return memo[n];
	}
}

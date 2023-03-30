package BackJoon;

import java.util.Scanner;

public class Prob9184 {

	static long[][][] memo = new long[21][21][21];

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		do {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();

			if (a == -1 && b == -1 && c == -1)
				break;

			System.out.printf("w(%d, %d, %d) = %d\n", a, b, c, topDown(a, b, c));
		} while (true);
	}

	private static long topDown(int a, int b, int c) {

		if (0 <= a && a <= 20 && 0 <= b && b <= 20 && 0 <= c && c <= 20 && memo[a][b][c] != 0) {
			return memo[a][b][c];
		}

		if (a <= 0 || b <= 0 || c <= 0) {
			return 1;
		}

		if (a > 20 || b > 20 || c > 20) {
			return memo[20][20][20] = topDown(20, 20, 20);
		}

		if (a < b && b < c) {
			return memo[a][b][c] = topDown(a, b, c - 1)
				+ topDown(a, b - 1, c - 1)
				- topDown(a, b - 1, c);
		}

		return memo[a][b][c] = topDown(a - 1, b, c)
			+ topDown(a - 1, b - 1, c)
			+ topDown(a - 1, b, c - 1)
			- topDown(a - 1, b - 1, c - 1);

	}
}
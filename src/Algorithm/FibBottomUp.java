package Algorithm;

import java.util.Scanner;

public class FibBottomUp {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println(bottomUp(sc.nextInt()));
	}

	static long bottomUp(int a) {

		long memo[] = new long[a + 1];

		memo[1] = 1;
		memo[2] = 1;

		for (int i = 3; i <= a; i++) {
			memo[i] = memo[i - 1] + memo[i - 2];
		}

		return memo[a];
	}
}

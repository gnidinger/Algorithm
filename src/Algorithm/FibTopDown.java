package Algorithm;

import java.util.Scanner;

public class FibTopDown {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println(topDown(sc.nextInt()));
	}

	static long topDown(int a) {

		long memo[] = new long[a + 1];

		if (a == 1 || a == 2) {
			return 1;
		}

		if (memo[a] != 0) {
			return memo[a];
		}

		return memo[a] = topDown(a - 1) + topDown(a - 2);
	}
}

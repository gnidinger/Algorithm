package BackJoon;

import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Prob1912 {

	private static final Set<Integer> set = new HashSet<>();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		topDown(arr, n - 1);

		System.out.println(Collections.max(set));
	}

	private static int topDown(int[] arr, int n) {

		Integer[] memo = new Integer[n + 1];

		memo[0] = arr[0];
		set.add(memo[0]);

		if (memo[n] == null) {
			memo[n] = Math.max(topDown(arr, n - 1) + arr[n], arr[n]);
			set.add(memo[n]);
		}

		return memo[n];
	}
}
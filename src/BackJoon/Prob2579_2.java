package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prob2579_2 {

	private static int[] memo;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n + 1];
		memo = new int[n + 1];

		for (int i = 0; i < n; i++) {
			arr[i + 1] = Integer.parseInt(br.readLine());
		}

		System.out.println(stairs(arr));
	}

	public static int stairs(int[] arr) {

		memo[1] = arr[1];

		if (arr.length >= 3) {
			memo[2] = arr[1] + arr[2];
		}

		for (int i = 3; i < arr.length; i++) {
			memo[i] = arr[i] + Math.max(memo[i - 2], arr[i - 1] + memo[i - 3]);
		}

		return memo[arr.length - 1];
	}
}

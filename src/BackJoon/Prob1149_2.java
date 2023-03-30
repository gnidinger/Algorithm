package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Prob1149_2 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[][] arr = new int[n][3];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][2] = Integer.parseInt(st.nextToken());
		}

		System.out.println(Math.min(bottomUp(arr, 2), Math.min(bottomUp(arr, 0), bottomUp(arr, 1))));
	}

	private static long bottomUp(int[][] arr, int t) {

		long[] memo = new long[arr.length];

		memo[0] = arr[0][t];

		for (int i = 1; i < arr.length; i++) {

			long x = memo[i - 1] + arr[i][(t + 1) % 3];
			long y = memo[i - 1] + arr[i][(t + 2) % 3];

			if (x < y) {
				memo[i] = x;
				t = (t + 1) % 3;
			} else if (x == y) {
				if (arr[i + 1][(t + 1) % 3] <= arr[i + 1][(t + 2) % 3]) {
					memo[i] = x;
				} else {
					memo[i] = y;
				}
			} else {
				memo[i] = y;
				t = (t + 2) % 3;
			}
			// memo[i] = Math.min(memo[i - 1] + arr[i][(t + 1) % 3], memo[i - 1] + arr[i][(t + 2) % 3]);
		}

		return memo[arr.length - 1];
	}
}

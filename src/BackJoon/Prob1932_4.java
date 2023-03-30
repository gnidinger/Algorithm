package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Prob1932_4 {

	private static int[] memo;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[][] arr = new int[n][n];
		memo = new int[n];

		for (int i = 0; i < n; i++) {

			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int j = 0; j <= i; j++) {

				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		bottomUp(arr);

		System.out.println(Arrays.stream(memo).max().getAsInt());
	}

	private static void bottomUp(int[][] arr) {

		memo[0] = arr[0][0];

		for (int i = 1; i < arr.length; i++) {
			int[] temp = new int[arr.length];
			for (int j = 0; j < arr.length; j++) {
				temp[j] = memo[j];
			}
			for (int j = 0; j <= i; j++) {
				if (j == 0) {
					memo[j] = temp[0] + arr[i][0];
				} else if (j == i) {
					memo[j] = temp[j - 1] + arr[i][i];
				} else {
					memo[j] = Math.max(temp[j - 1], temp[j]) + arr[i][j];
				}
			}
		}
	}
}

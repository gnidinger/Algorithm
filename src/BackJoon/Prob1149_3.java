package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prob1149_3 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[][] arr = new int[n][3];
		int[][] memo = new int[n][3];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			arr[i][0] = Integer.parseInt(st.nextToken()); // R
			arr[i][1] = Integer.parseInt(st.nextToken()); // G
			arr[i][2] = Integer.parseInt(st.nextToken()); // B
		}

		memo[0][0] = arr[0][0];
		memo[0][1] = arr[0][1];
		memo[0][2] = arr[0][2];

		for (int i = 1; i < n; i++) {
			memo[i][0] = Math.min(memo[i - 1][1], memo[i - 1][2]) + arr[i][0];
			memo[i][1] = Math.min(memo[i - 1][0], memo[i - 1][2]) + arr[i][1];
			memo[i][2] = Math.min(memo[i - 1][0], memo[i - 1][1]) + arr[i][2];
		}

		System.out.println(Math.min(memo[n - 1][0], Math.min(memo[n - 1][1], memo[n - 1][2])));

	}
}

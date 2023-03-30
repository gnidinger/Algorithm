package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class Prob1149 {

	private static Set<Integer> set = new HashSet<>();
	private static int[][] memo;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[][] arr = new int[n][3];
		memo = new int[n][3];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][2] = Integer.parseInt(st.nextToken());
		}

		set.add(topDown(arr, n - 1, 0));
		set.add(topDown(arr, n - 1, 1));
		set.add(topDown(arr, n - 1, 2));

		System.out.println(Collections.min(set));
	}

	private static int topDown(int[][] arr, int i, int j) {

		memo[0][0] = arr[0][0];
		memo[0][1] = arr[0][1];
		memo[0][2] = arr[0][2];

		if (memo[i][j] == 0) {

			if (j == 0)
				memo[i][0] = Math.min(topDown(arr, i - 1, 1), topDown(arr, i - 1, 2)) + arr[i][0];
			else if (j == 1)
				memo[i][1] = Math.min(topDown(arr, i - 1, 0), topDown(arr, i - 1, 2)) + arr[i][1];
			else if (j == 2)
				memo[i][2] = Math.min(topDown(arr, i - 1, 0), topDown(arr, i - 1, 1)) + arr[i][2];
		}

		return memo[i][j];
	}
}
package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Prob1912_2 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] inputArr = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			inputArr[i] = Integer.parseInt(st.nextToken());
		}

		System.out.println(bottomUp(inputArr));
	}

	static long bottomUp(int[] arr) {

		long[][] memo = new long[arr.length + 1][arr.length + 1];
		Set<Long> resultSet = new HashSet<>();

		for (int i = 0; i < arr.length; i++) {
			memo[0][i] = arr[i];
			resultSet.add(memo[0][i]);
		}

		for (int i = 1; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				long temp = 0;
				for (int k = i - 1; k <= j; k++) {
					temp += memo[0][k];
				}
				resultSet.add(temp);
			}
		}
		return Collections.max(resultSet);
	}
}

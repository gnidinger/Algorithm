package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prob1912_3 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] inputArr = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			inputArr[i] = Integer.parseInt(st.nextToken());
		}

		long[] memo = new long[n];
		memo[0] = inputArr[0];
		long max = inputArr[0];

		for (int i = 1; i < n; i++) {
			memo[i] = Math.max(memo[i - 1] + inputArr[i], inputArr[i]);
			max = Math.max(memo[i], max);
		}
		System.out.println(max);
	}
}

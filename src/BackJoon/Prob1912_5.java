package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prob1912_5 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] memo = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		memo[0] = arr[0];
		int max = arr[0];

		for (int i = 1; i < n; i++) {
			memo[i] = Math.max(memo[i - 1] + arr[i], arr[i]);
			max = Math.max(max, memo[i]);
		}

		System.out.println(max);
	}
}

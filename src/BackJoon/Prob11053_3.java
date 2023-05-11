package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Prob11053_3 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] memo = new int[n];
		Arrays.fill(memo, 1);
		int result = 1;

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				if (arr[j] < arr[i] && memo[i] < memo[j] + 1) {
					memo[i] = memo[j] + 1;
					result = Math.max(result, memo[i]);
				}
			}
		}

		System.out.println(result);
	}
}

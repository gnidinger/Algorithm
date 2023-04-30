package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Prob1912_4 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] intArr = new int[n];
		int[] memo = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			intArr[i] = Integer.parseInt(st.nextToken());
		}

		memo[0] = intArr[0];
		int max = intArr[0];

		for (int i = 1; i < n; i++) {
			memo[i] = Math.max(memo[i - 1] + intArr[i], intArr[i]);
			max = Math.max(memo[i], max);
		}

		System.out.println(max);

	}
}

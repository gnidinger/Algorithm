package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;

public class Prob14888_3 {

	static int n;
	static int[] numbers;
	static int[] operators;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		numbers = new int[n];
		operators = new int[4];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			operators[i] = Integer.parseInt(st.nextToken());
		}

	}

	private static void operate(int idx, int sum) {
		if (idx == n) {
			max = Math.max(max, sum);
		}
	}
}

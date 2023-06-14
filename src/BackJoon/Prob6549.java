package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prob6549 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());

			if (n == 0){
				break;
			}

			int[] height = new int[n];

			for (int i = 0; i < n; i++) {
				height[i] = Integer.parseInt(st.nextToken());
			}

			long max = calcMax(height);
			sb.append(max).append('\n');
		}

		System.out.println(sb.toString());
	}

	private static long calcMax(int[] height) {

		int n = height.length;
		long max = 0;

		for (int i = 0; i < n; i++) {
			int minHeight = height[i];

			for (int j = i; j < n; j++) {
				minHeight = Math.min(minHeight, height[j]);
				long temp = (long) minHeight * (j - i + 1);
				max = Math.max(max, temp);
			}
		}

		return max;
	}
}

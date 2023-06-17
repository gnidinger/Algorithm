package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prob2805 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] trees = new int[n];
		int max = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, trees[i]);
		}

		long left = 0;
		long right = max;
		long answer = 0;

		while (left <= right) {
			long mid = (left + right) / 2;
			long sum = 0;

			for (int i = 0; i < n; i++) {
				if (trees[i] > mid) {
					sum += trees[i] - mid;
				}
			}

			if (sum >= m) {
				answer = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		System.out.println(answer);
	}
}

package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prob1654 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int k = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		long[] lengths = new long[k];
		long max = 0;

		for (int i = 0; i < k; i++) {
			lengths[i] = Long.parseLong(br.readLine());
			max = Math.max(max, lengths[i]);
		}

		long left = 1;
		long right = max;
		long answer = 0;

		while (left <= right) {
			long mid = (left + right) / 2;
			long count = 0;

			for (int i = 0; i < k; i++) {
				count += lengths[i] / mid;
			}

			if (count >= n) {
				answer = Math.max(answer, mid);
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		System.out.println(answer);
	}
}

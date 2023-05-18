package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Prob2565_2 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[][] wire = new int[n][2];
		int[] memo = new int[n];
		Arrays.fill(memo, 1);

		for (int i = 0; i < n; i++) {

			StringTokenizer st = new StringTokenizer(br.readLine());

			wire[i][0] = Integer.parseInt(st.nextToken());
			wire[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(wire, (a, b) -> Integer.compare(a[0], b[0]));

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (wire[j][1] < wire[i][1]) {
					memo[i] = Math.max(memo[i], memo[j] + 1);
				}
			}
		}

		int max = Arrays.stream(memo).max().getAsInt();
		System.out.println(n - max);
	}
}

package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class prob9184_2 {

	static long[][][] memo = new long[21][21][21];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {

			StringTokenizer st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			if (a == -1 && b == -1 && c == -1)
				break;

			sb.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ")
				.append(topDown(a, b, c)).append('\n');
		}
		System.out.println(sb);
	}

	public static long topDown(int a, int b, int c) {

		if (a <= 0 || b <= 0 || c <= 0) {
			return 1;
		}

		if (0 < a && a <= 20 && 0 < b && b <= 20 && 0 < c && c <= 20 && memo[a][b][c] != 0) {
			return memo[a][b][c];
		}

		if (20 < a || 20 < b || 20 < c) {
			return memo[20][20][20] = topDown(20, 20, 20);
		}

		if (a < b && b < c) {
			return memo[a][b][c] = topDown(a, b, c - 1) + topDown(a, b - 1, c - 1) - topDown(a, b - 1, c);
		}

		return memo[a][b][c] =
			topDown(a - 1, b, c) + topDown(a - 1, b - 1, c)
				+ topDown(a - 1, b, c - 1) - topDown(a - 1, b - 1, c - 1);
	}
}

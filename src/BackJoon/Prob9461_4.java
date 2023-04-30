package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prob9461_4 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			int m = Integer.parseInt(br.readLine());
			long[] memo = new long[m + 1];

			if (m == 1) {
				System.out.println(1);
				continue;
			}

			memo[0] = 0;
			memo[1] = 1;
			memo[2] = 1;

			for (int j = 3; j <= m; j++) {
				memo[j] = memo[j - 2] + memo[j - 3];
			}

			System.out.println(memo[m]);
		}
	}
}

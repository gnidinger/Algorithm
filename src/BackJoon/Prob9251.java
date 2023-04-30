package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prob9251 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String n = br.readLine();
		String m = br.readLine();

		int[][] memo = new int[n.length() + 1][m.length() + 1];

		for (int i = 1; i <= n.length(); i++) {
			for (int j = 1; j <= m.length(); j++) {
				if (n.charAt(i - 1) == m.charAt(j - 1)) {
					memo[i][j] = memo[i - 1][j - 1] + 1;
				} else {
					memo[i][j] = Math.max(memo[i - 1][j], memo[i][j - 1]);
				}
			}
		}

		System.out.println(memo[n.length()][m.length()]);
	}
}

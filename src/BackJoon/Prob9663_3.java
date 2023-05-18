package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prob9663_3 {

	static int n;
	static int result;
	static int[] column;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		column = new int[n];

		dfs(0);

		System.out.println(result);
	}

	static void dfs(int depth) {

		if (depth == n) {
			result++;
			return;
		}

		for (int i = 0; i < n; i++) {
			column[depth] = i;
			if (isPossible(depth)) {
				dfs(depth + 1);
			}
		}
	}

	static boolean isPossible(int depth) {
		for (int i = 0; i < depth; i++) {
			if (column[i] == column[depth] || Math.abs(column[depth] - column[i]) == depth - i) {
				return false;
			}
		}
		return true;
	}
}

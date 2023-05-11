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

	static void dfs(int row) {

		if (row == n) {
			result++;
			return;
		}

		for (int i = 0; i < n; i++) {
			column[row] = i;
			if (isPossible(row)) {
				dfs(row + 1);
			}
		}
	}

	static boolean isPossible(int row) {
		for (int i = 0; i < row; i++) {
			if (column[i] == column[row] || Math.abs(column[row] - column[i]) == row - i) {
				return false;
			}
		}
		return true;
	}
}

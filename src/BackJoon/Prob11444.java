package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prob11444 {

	static final long p = 1000000007;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long n = Long.parseLong(br.readLine());

		if (n == 1) {
			System.out.println(1);
			System.exit(0);
		}

		long[][] matrix = {{1, 1}, {1, 0}};
		long[][] result = power(matrix, n - 1);

		System.out.println(result[0][0]);
	}

	public static long[][] power(long[][] matrix, long exp) {

		if (exp == 1) {
			return matrix;
		}

		long[][] temp = power(matrix, exp / 2);
		long[][] result = multiply(temp, temp);

		if (exp % 2 == 1) {
			result = multiply(result, matrix);
		}

		return result;
	}

	private static long[][] multiply(long[][] a, long[][] b) {

		int x = a.length;
		int y = b[0].length;
		int z = b.length;

		long[][] result = new long[x][y];

		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				for (int k = 0; k < z; k++) {
					result[i][j] += (a[i][k] * b[k][j]) % p;
					result[i][k] %= p;
				}
			}
		}

		return result;
	}
}

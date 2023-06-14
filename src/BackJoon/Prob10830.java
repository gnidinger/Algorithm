package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prob10830 {

	static int n;
	static long b;
	static int[][] A;
	static int p = 1000;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		b = Long.parseLong(st.nextToken());
		A = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				A[i][j] = Integer.parseInt(st.nextToken()) % p;
			}
		}

		int[][] result = pow(A, b);

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(result[i][j] + " ");
			}

			System.out.println();
		}

	}

	public static int[][] pow(int[][] A, long exponent) {

		if (exponent == 1L) {
			return A;
		}

		int[][] temp = pow(A, exponent / 2);
		temp = multiply(temp, temp);

		if (exponent % 2 == 1) {
			temp = multiply(temp, A);
		}

		return temp;
	}

	public static int[][] multiply(int[][] A, int[][] B) {

		int[][] C = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					C[i][j] += (A[i][k] * B[k][j]) % p;
				}
				C[i][j] %= p;
			}
		}

		return C;
	}
}

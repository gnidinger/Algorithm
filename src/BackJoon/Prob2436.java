package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prob2436 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int gcd = Integer.parseInt(st.nextToken());
		int lcm = Integer.parseInt(st.nextToken());

		int condition = lcm / gcd;

		int a = 0;
		int b = 0;
		int min = Integer.MAX_VALUE;

		for (int i = 1; i <= Math.sqrt(condition); i++) {
			if (condition % i == 0) {
				int j = condition / i;
				if (gcd(i, j) == 1) {
					int current_sum = i + j;
					if (current_sum < min) {
						min = current_sum;
						a = i * gcd;
						b = j * gcd;
					}
				}
			}
		}
		System.out.println(a + " " + b);
	}

	private static int gcd(int a, int b) {
		while (b != 0) {
			int temp = a % b;
			a = b;
			b = temp;
		}
		return a;
	}
}

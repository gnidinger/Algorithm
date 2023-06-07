package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prob11401 {

	static final long mod = 1000000007;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		long[] factorial = new long[n + 1];
		factorial[0] = 1;
		factorial[1] = 1;

		for (int i = 2; i <= n; i++) {
			factorial[i] = (factorial[i - 1] * i) % mod;
		}

		long denominator = (factorial[k] * factorial[n - k]) % mod;

		System.out.println((factorial[n] * power(denominator, mod - 2)) % mod);

	}

	private static long power(long base, long exponent) {

		if (exponent == 1) {
			return base % mod;
		}

		long half = power(base, exponent / 2);

		if (exponent % 2 == 0) {
			return (half * half) % mod;
		} else {
			return (((half * half) % mod) * base) % mod;
		}
	}
}

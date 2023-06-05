package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prob1629 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		System.out.println(pow(a, b, c));
	}

	private static int pow(int a, int exponent, int mod) {

		if (exponent == 1) {
			return a % mod;
		}

		int temp = pow(a, exponent / 2, mod);

		if (exponent % 2 == 0) {
			return (temp * temp) % mod;
		} else {
			return (((temp * temp) % mod) * a) % mod;
		}
	}
}

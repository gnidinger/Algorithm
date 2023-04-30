package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prob2720 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		int quarter = 25;
		int dime = 10;
		int nickel = 5;
		int penny = 1;

		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			int a = n / quarter;
			int b = (n % quarter) / dime;
			int c = ((n % quarter) % dime) / nickel;
			int d = (((n % quarter) % dime) % nickel) / penny;
			System.out.printf("%d %d %d %d \n", a, b, c, d);
		}
	}
}

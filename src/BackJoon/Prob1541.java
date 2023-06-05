package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prob1541 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String expression = br.readLine();

		int total = 0;
		int subTotal = 0;
		boolean isSubtract = false;

		for (int i = 0; i < expression.length(); i++) {

			char ch = expression.charAt(i);

			if (ch == '+' || ch == '-') {

				total += isSubtract ? -subTotal : subTotal;
				subTotal = 0;

				if (ch == '-') {
					isSubtract = true;
				}
			} else {
				subTotal = subTotal * 10 + (ch - '0');
			}
		}

		total += isSubtract ? -subTotal : subTotal;

		System.out.println(total);
	}
}

package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Prob2981_4 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			list.add(Integer.parseInt(br.readLine()));
		}

		Collections.sort(list);

		int result = list.get(1) - list.get(0);

		for (int i = 2; i < n; i++) {
			result = gcd(result, list.get(i) - list.get(i - 1));
		}

		StringBuilder stringBuilder = new StringBuilder();

		for (int i = 2; i <= result / 2; i++) {
			if (result % i == 0) {
				stringBuilder.append(i).append(" ");
			}
		}
		System.out.println(stringBuilder.toString());
	}

	private static int gcd(int a, int b) {
		while(b != 0) {
			int r = a % b;
			a = b;
			b = r;
		}
		return a;
	}
}
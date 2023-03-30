package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Prob2981_5 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		List<Integer> list = new ArrayList<>();
		List<Integer> subList = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			list.add(Integer.parseInt(br.readLine()));
		}

		for (int i = 1; i < n; i++) {
			subList.add(Math.abs(list.get(i) - list.get(i - 1)));
		}

		int result = subList.stream()
			.reduce(Prob2981_5::gcd)
			.get();

		StringBuilder stringBuilder = new StringBuilder();

		for (int i = 2; i <= result; i++) {
			if (result % i == 0) {
				stringBuilder.append(i).append(" ");
			}
		}

		System.out.println(stringBuilder);
	}

	private static int gcd(int a, int b) {
		while (b != 0) {
			int r = a % b;
			a = b;
			b = r;
		}
		return a;
	}
}
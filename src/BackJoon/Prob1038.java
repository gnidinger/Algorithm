package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Prob1038 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		ArrayDeque<Long> deque = new ArrayDeque<>();

		for (long i = 0; i <= 9; i++) {
			deque.add(i);
		}

		long number = -1;

		while (n >= 0 && !deque.isEmpty()) {
			number = deque.poll();
			long lastDigit = number % 10;
			for (long i = 0; i < lastDigit; i++) {
				deque.add(number * 10 + i);
			}
			n--;
		}

		if (n < 0) {
			System.out.println(number);
		} else {
			System.out.println(-1);
		}
	}
}

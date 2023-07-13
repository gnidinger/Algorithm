package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Prob3015 {

	static class Person {
		long height;
		long count;

		public Person(long height, long count) {
			this.height = height;
			this.count = count;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		ArrayDeque<Person> stack = new ArrayDeque<>();
		long result = 0;

		for (int i = 0; i < n; i++) {
			long height = Long.parseLong(br.readLine());
			long count = 1;

			while (!stack.isEmpty()) {
				if (stack.peek().height <= height) {
					result += stack.peek().count;
					if (stack.peek().height == height) {
						count += stack.peek().count;
					}
					stack.pop();
				} else {
					break;
				}
			}

			if (!stack.isEmpty()) {
				result++;
			}

			stack.push(new Person(height, count));
		}

		System.out.println(result);
	}
}

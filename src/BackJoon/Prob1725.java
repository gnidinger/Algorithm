package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Prob1725 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] height = new int[n + 1];

		for (int i = 0; i < n; i++) {
			height[i] = Integer.parseInt(br.readLine());
		}

		ArrayDeque<Integer> stack = new ArrayDeque<>();

		int result = 0;

		for (int i = 0; i <= n; i++) {
			while (!stack.isEmpty() && height[stack.peek()] >= height[i]) {
				int h = height[stack.pop()];
				int w;

				if (stack.isEmpty()) {
					w = i;
				} else {
					w = i - stack.peek() - 1;
				}
				result = Math.max(result, h * w);
			}
			stack.push(i);
		}

		System.out.println(result);
	}
}

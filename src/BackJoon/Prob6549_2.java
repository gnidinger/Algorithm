package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Prob6549_2 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());

			if (n == 0) {
				break;
			}

			int[] height = new int[n];

			for (int i = 0; i < n; i++) {
				height[i] = Integer.parseInt(st.nextToken());
			}

			ArrayDeque<Integer> stack = new ArrayDeque<>();
			long max = 0;

			for (int i = 0; i < n; i++) {
				while (!stack.isEmpty() && height[stack.peek()] > height[i]) {
					long h = height[stack.pop()];
					int w = i;
					if (!stack.isEmpty()) {
						w = i - stack.peek() - 1;
					}
					max = Math.max(max, h * w);
				}
				stack.push(i);
			}

			while (!stack.isEmpty()) {
				long h = height[stack.pop()];
				int w = n;
				if (!stack.isEmpty()) {
					w = n - stack.peek() - 1;
				}
				max = Math.max(max, h * w);
			}

			sb.append(max).append('\n');
		}

		System.out.println(sb.toString());
	}
}

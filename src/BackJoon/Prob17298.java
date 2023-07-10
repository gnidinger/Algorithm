package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Prob17298 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] result = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		ArrayDeque<Integer> stack = new ArrayDeque<>();
		stack.push(0);

		for (int i = 1; i < n; i++) {
			while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
				result[stack.pop()] = arr[i];
			}
			stack.push(i);
		}

		while (!stack.isEmpty()) {
			result[stack.pop()] = -1;
		}

		StringBuilder sb = new StringBuilder();
		for (int i : result) {
			sb.append(i).append(' ');
		}

		System.out.println(sb);
	}
}

package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Prob17299 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] freq = new int[1000001];
		int[] result = new int[n];
		Arrays.fill(result, -1);

		ArrayDeque<Integer> stack = new ArrayDeque<>();

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			freq[arr[i]]++;
		}

		stack.push(0);
		for (int i = 1; i < n; i++) {
			while (!stack.isEmpty() && freq[arr[stack.peek()]] < freq[arr[i]]) {
				result[stack.pop()] = arr[i];
			}
			stack.push(i);
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(result[i]).append(' ');
		}

		System.out.println(sb);
	}
}

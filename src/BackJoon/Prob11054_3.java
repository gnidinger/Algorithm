package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Prob11054_3 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] increase = new int[n];
		int[] decrease = new int[n];
		int result = 1;

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.fill(increase, 1);
		Arrays.fill(decrease, 1);

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i]) {
					increase[i] = Math.max(increase[i], increase[j] + 1);
				}
			}
		}

		for (int i = n - 1; i >= 0; i--) {
			for (int j = n - 1; j > i; j--) {
				if (arr[j] < arr[i]) {
					decrease[i] = Math.max(decrease[i], decrease[j] + 1);
				}
			}
		}

		for (int i = 0; i < n; i++) {
			result = Math.max(result, increase[i] + decrease[i] - 1);
		}

		System.out.println(result);
	}
}

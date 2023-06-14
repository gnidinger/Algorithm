package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Prob1920 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		int m = Integer.parseInt(br.readLine());
		int[] numbers = new int[m];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < m; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}

		StringBuilder sb = new StringBuilder();

		for (int number : numbers) {
			boolean isFound = false;
			int left = 0;
			int right = n - 1;

			while (left <= right) {
				int mid = (left + right) / 2;

				if (arr[mid] == number) {
					isFound = true;
					break;
				} else if (arr[mid] < number) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}

			sb.append(isFound? 1 : 0).append('\n');
		}

		System.out.println(sb.toString());
	}
}

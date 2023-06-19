package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Prob12015 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		int[] lis = new int[n];
		int length = 0;

		for (int i = 0; i < n; i++) {
			int left = 0;
			int right = length;

			while (left < right) {
				int mid = (left + right) / 2;

				if (lis[mid] < numbers[i]) {
					left = mid + 1;
				} else {
					right = mid;
				}
			}

			lis[left] = numbers[i];

			if (left == length) {
				length++;
			}
		}

		System.out.println(length);
	}
}

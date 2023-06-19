package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Prob2110 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int[] houses = new int[n];

		for (int i = 0; i < n; i++) {
			houses[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(houses);

		int left = 1;
		int right = houses[n - 1] - houses[0];
		int answer = 0;

		while (left <= right) {

			int mid = (left + right) / 2;
			int start = houses[0];
			int count = 1;

			for (int house : houses) {
				int distance = house - start;
				if (distance >= mid) {
					count++;
					start = house;
				}
			}

			if (count >= c) {
				answer = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		System.out.println(answer);
	}
}

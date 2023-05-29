package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Prob1931 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[][] meetings = new int[n][2];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			meetings[i][0] = Integer.parseInt(st.nextToken());
			meetings[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(meetings, Comparator.comparingInt((int[] value) -> value[1]).thenComparingInt(value -> value[0]));

		int count = 1;
		int endTime = meetings[0][1];

		for (int i = 1; i < n; i++) {
			if (meetings[i][0] >= endTime) {
				count++;
				endTime = meetings[i][1];
			}
		}

		System.out.println(count);
	}
}

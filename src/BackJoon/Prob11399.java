package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Prob11399 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] durations = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			durations[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(durations);

		int total = 0;
		int waiting = 0;

		for (int i = 0; i < n; i++) {
			waiting += durations[i];
			total += waiting;
		}

		System.out.println(total);
	}
}

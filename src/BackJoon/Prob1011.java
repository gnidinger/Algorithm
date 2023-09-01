package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prob1011 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			long x = Long.parseLong(st.nextToken());
			long y = Long.parseLong(st.nextToken());
			long distance = y - x;

			long k = 1;
			while (k * k < distance) {
				k++;
			}

			if (k * k == distance) {
				System.out.println(2 * k - 1);
			} else if (k * k - k < distance && distance < k * k) {
				System.out.println(2 * k - 1);
			} else {
				System.out.println(2 * k - 2);
			}
		}
	}
}

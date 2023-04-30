package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prob11005 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		StringBuilder sb = new StringBuilder();
		while (n > 0) {
			int temp = n % b;
			if (temp < 10) {
				sb.append(temp);
			} else {
				sb.append((char)(temp - 10 + 'A'));
			}
			n /= b;
		}

		System.out.println(sb.reverse());
	}
}

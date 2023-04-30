package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prob2745 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		String n = st.nextToken();
		int b = Integer.parseInt(st.nextToken());

		int sum = 0;

		for (int i = 0; i < n.length(); i++) {
			char c = n.charAt(n.length() - 1 - i);
			if ('0' <= c && c <= '9') {
				sum += (c - '0') * Math.pow(b, i);
			} else {
				sum += (c - 55) * Math.pow(b, i);
			}
		}

		System.out.println(sum);
	}
}

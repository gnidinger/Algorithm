package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prob16139_4 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String str = br.readLine();
		int n = str.length();
		int q = Integer.parseInt(br.readLine());
		int[][] sum = new int[26][n + 1];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 26; j++) { // 문자열 처음 인덱스부터 순회
				sum[j][i + 1] = sum[j][i];
			}
			sum[str.charAt(i) - 'a'][i + 1]++; // 알파벳 -> 아스키코드 매핑
		}

		for (int i = 0; i < q; i++) {
			String[] query = br.readLine().split(" ");
			int chr = query[0].charAt(0) - 'a';
			int start = Integer.parseInt(query[1]);
			int end = Integer.parseInt(query[2]);

			int count = sum[chr][end + 1] - sum[chr][start];
			sb.append(count).append('\n');
		}

		System.out.println(sb);
	}
}
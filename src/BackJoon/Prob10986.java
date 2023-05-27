package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prob10986 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		long[] sum = new long[n];
		long[] cnt = new long[m];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (i > 0) {
				sum[i] = sum[i - 1];
			}
			sum[i] += num;

			int remain = (int)(sum[i] % m);
			cnt[remain]++; // 나머지 값의 개수에 따라 누적합 분류
		}

		long result = cnt[0];  // 누적합 중 나머지가 0인 개수로 초기화

		for (int i = 0; i < m; i++) {
			result += (cnt[i] * (cnt[i] - 1)) / 2;  // 나머지가 같은 경우 그 차이는 M으로 나누어 떨어진다.
		}

		System.out.println(result);
	}
}

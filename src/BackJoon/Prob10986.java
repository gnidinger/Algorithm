package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prob10986 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		long[] prefixSum = new long[N];
		long[] count = new long[M];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (i > 0) {
				prefixSum[i] = prefixSum[i - 1];
			}
			prefixSum[i] += num;

			int remainder = (int) (prefixSum[i] % M);
			count[remainder]++;
		}

		long result = count[0];  // 나머지가 0인 경우의 수 전체를 먼저 추가

		for (int i = 0; i < M; i++) {
			result += (count[i] * (count[i] - 1)) / 2;  // 나머지가 같은 두 위치에서 합이 M으로 나누어떨어지는 경우를 찾아 추가
		}

		System.out.println(result);
	}
}


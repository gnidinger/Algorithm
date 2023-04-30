package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prob12865 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[][] arr = new int[n + 1][2];
		int[][] memo = new int[n + 1][k + 1];

		for (int i = 1; i <= n; i++) {
			StringTokenizer temp = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(temp.nextToken());
			int b = Integer.parseInt(temp.nextToken());
			int[] tempArr = {a, b};
			arr[i] = tempArr;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= k; j++) {
				if (arr[i][0] > j) {
					memo[i][j] = memo[i - 1][j];
				} else {
					memo[i][j] = Math.max(memo[i - 1][j], memo[i - 1][j - arr[i][0]] + arr[i][1]);
				}
			}
		}
		System.out.println(memo[n][k]);
	}
}

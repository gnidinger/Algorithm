package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prob15650_2 {

	static int n;
	static int m;
	static int[] arr;
	static boolean[] isVisited;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[m];
		isVisited = new boolean[n + 1];

		dfs(1, 0);

	}

	private static void dfs(int start, int depth) {
		if (depth == m) {
			for (int num : arr) {
				System.out.print(num + " ");
			}
			System.out.println();
			return;
		}

		for (int i = start; i <= n; i++) {
			if (!isVisited[i]) {
				isVisited[i] = true;
				arr[depth] = i;
				dfs(i, depth + 1);
				isVisited[i] = false;
			}
		}
	}
}

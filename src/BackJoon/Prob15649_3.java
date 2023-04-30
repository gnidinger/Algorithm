package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prob15649_3 {

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

		dfs(0);
	}

	public static void dfs(int depth) {
		if (depth == m) {
			for (int num : arr) {
				System.out.print(num + " ");
			}
			System.out.println();
			return;
		}

		for (int i = 1; i <= n; i++) {
			if (!isVisited[i]) {
				isVisited[i] = true;
				arr[depth] = i;
				dfs(depth + 1);
				isVisited[i] = false;
			}
		}
	}
}

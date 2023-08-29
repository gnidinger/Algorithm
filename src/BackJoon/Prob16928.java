package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Prob16928 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] board = new int[101];
		boolean[] visited = new boolean[101];

		for (int i = 0; i < n + m; i++) {
			st = new StringTokenizer(br.readLine());

			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			board[u] = v;
		}

		ArrayDeque<int[]> queue = new ArrayDeque<>();

		queue.add(new int[]{1, 0});
		visited[1] = true;

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int pos = cur[0];
			int count = cur[1];

			if (pos == 100) {
				System.out.println(count);
				return;
			}

			for (int i = 0; i < 7; i++) {
				int nextPos = pos + i;

				if (nextPos > 100) {
					continue;
				}

				if (board[nextPos] != 0) {
					nextPos = board[nextPos];
				}

				if (!visited[nextPos]) {
					visited[nextPos] = true;
					queue.add(new int[]{nextPos, count + 1});
				}
			}
		}
	}
}

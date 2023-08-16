package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Prob7576 {

	static int m;
	static int n;
	static int[][] box;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		box = new int[n][m];
		ArrayDeque<int[]> queue = new ArrayDeque<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				if (box[i][j] == 1) {
					queue.offer(new int[] {i, j});
				}
			}
		}

		bfs(queue);

		int result = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (box[i][j] == 0) {
					System.out.println(-1);
					return;
				}
				result = Math.max(result, box[i][j]);
			}
		}
		System.out.println(result - 1);
	}

	private static void bfs(ArrayDeque<int[]> queue) {
		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nx = current[0] + dx[i];
				int ny = current[1] + dy[i];
				if (0 <= nx && nx < n && 0 <= ny && ny < m && box[nx][ny] == 0) {
					box[nx][ny] = box[current[0]][current[1]] + 1;
					queue.offer(new int[] {nx, ny});
				}
			}
		}
	}
}

package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Prob1012_BFS {

	static int m;
	static int n;
	static int[][] field;
	static boolean[][] visited;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			field = new int[m][n];
			visited = new boolean[m][n];

			for (int j = 0; j < k; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				field[x][y] = 1;
			}

			int count = 0;

			for (int a = 0; a < m; a++) {
				for (int b = 0; b < n; b++) {
					if (field[a][b] == 1 && !visited[a][b]) {
						bfs(a, b);
						count++;
					}
				}
			}
			System.out.println(count);
		}
	}

	private static void bfs(int x, int y) {
		ArrayDeque<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[]{x, y});
		visited[x][y] = true;

		while (!queue.isEmpty()) {
			int[] current = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = current[0] + dx[i];
				int ny = current[1] + dy[i];

				if (0 <= nx && nx < m && 0 <= ny && ny < n) {
					if (field[nx][ny] == 1 && !visited[nx][ny]) {
						queue.offer(new int[]{nx, ny});
						visited[nx][ny] = true;
					}
				}
			}
		}
	}
}

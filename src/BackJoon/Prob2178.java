package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Prob2178 {

	static int n;
	static int m;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visited = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			String input = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = input.charAt(j) - '0';
			}
		}

		bfs(0, 0);

		System.out.println(map[n - 1][m - 1]);
	}

	private static void bfs(int x, int y) {
		ArrayDeque<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[]{x, y});
		visited[x][y] = true;

		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			int curX = current[0];
			int curY = current[1];

			for (int i = 0; i < 4; i++) {
				int nx = curX + dx[i];
				int ny = curY + dy[i];

				if (0 <= nx && nx < n && 0 <= ny && ny < m && map[nx][ny] == 1 && !visited[nx][ny]) {
					queue.offer(new int[]{nx, ny});
					visited[nx][ny] = true;
					map[nx][ny] = map[curX][curY] + 1;
				}
			}
		}
	}
}

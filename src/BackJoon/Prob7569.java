package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Prob7569 {

	static int[][][] box;
	static boolean[][][] visited;
	static int m;
	static int n;
	static int h;
	static int[] dx = {1, -1, 0, 0, 0, 0};
	static int[] dy = {0, 0, 1, -1, 0, 0};
	static int[] dz = {0, 0, 0, 0, 1, -1};
	static class Tomato {
		int x;
		int y;
		int z;

		Tomato(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());

		box = new int[h][n][m];
		visited = new boolean[h][n][m];

		ArrayDeque<Tomato> deque = new ArrayDeque<>();

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < m; k++) {
					box[i][j][k] = Integer.parseInt(st.nextToken());
					if (box[i][j][k] == 1) {
						deque.add(new Tomato(k, j, i));
						visited[i][j][k] = true;
					}
				}
			}
		}

		int days = bfs(deque) - 1;
		if (days < 0) {
			days = 0;
		}

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < m; k++) {
					if (box[i][j][k] == 0) {
						System.out.println(-1);
						return;
					}
				}
			}
		}

		System.out.println(days);
	}

	static int bfs(ArrayDeque<Tomato> deque) {
		int days = 0;

		while (!deque.isEmpty()) {
			int size = deque.size();
			for (int i = 0; i < size; i++) {
				Tomato tomato = deque.poll();
				for (int j = 0; j < 6; j++) {
					int nx = tomato.x + dx[j];
					int ny = tomato.y + dy[j];
					int nz = tomato.z + dz[j];

					if (nx < 0 || nx >= m || ny < 0 || ny >= n || nz < 0 || nz >= h) {
						continue;
					}

					if (visited[nz][ny][nx] || box[nz][ny][nx] != 0) {
						continue;
					}

					visited[nz][ny][nx] = true;
					box[nz][ny][nx] = 1;
					deque.add(new Tomato(nx, ny, nz));
				}
			}
			days++;
		}
		return days;
	}
}

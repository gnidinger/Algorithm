package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Prob7562 {

	static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
	static int[] dy = {1, 2, 2, 1, -1, -2, -2 ,-1};

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			int l = Integer.parseInt(br.readLine());;

			StringTokenizer st = new StringTokenizer(br.readLine());
			int startX = Integer.parseInt(st.nextToken());
			int startY = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			int endX = Integer.parseInt(st.nextToken());
			int endY = Integer.parseInt(st.nextToken());

			System.out.println(bfs(l, startX, startY, endX, endY));
		}
	}

	private static int bfs(int l, int startX, int startY, int endX, int endY) {
		ArrayDeque<int[]> queue = new ArrayDeque();
		boolean[][] visited = new boolean[l][l];
		queue.offer(new int[]{startX, startY, 0});
		visited[startX][startY] = true;

		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			int x = current[0];
			int y = current[1];
			int count = current[2];

			if (x == endX && y == endY) {
				return count;
			}

			for (int i = 0; i < 8; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (0 <= nx && nx < l && 0 <= ny && ny < l && !visited[nx][ny]) {
					visited[nx][ny] = true;
					queue.offer(new int[]{nx, ny, count + 1});
				}
			}
		}
		return -1;
	}
}

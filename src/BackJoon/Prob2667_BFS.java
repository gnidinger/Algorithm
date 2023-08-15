package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Prob2667_BFS {

	static int n;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		visited = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			String input = br.readLine();
			for (int j = 0; j < n; j++) {
				map[i][j] = input.charAt(j) - '0';
			}
		}

		List<Integer> houseList = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					houseList.add(bfs(i, j));
				}
			}
		}

		Collections.sort(houseList);
		System.out.println(houseList.size());

		for (int house : houseList) {
			System.out.println(house);
		}
	}

	private static int bfs(int x, int y) {
		ArrayDeque<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {x, y});
		visited[x][y] = true;
		int count = 1;

		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nx = current[0] + dx[i];
				int ny = current[1] + dy[i];

				if (0 <= nx && nx < n && 0 <= ny && ny < n) {
					if (map[nx][ny] == 1 && !visited[nx][ny]) {
						queue.offer(new int[] {nx, ny});
						visited[nx][ny] = true;
						count++;
					}
				}
			}
		}
		return count;
	}
}

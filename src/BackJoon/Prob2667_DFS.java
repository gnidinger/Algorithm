package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Prob2667_DFS {

	static int n;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static List<Integer> houseList = new ArrayList<>();

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

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					houseList.add(dfs(i, j));
				}
			}
		}

		Collections.sort(houseList);
		System.out.println(houseList.size());

		for (int house : houseList) {
			System.out.println(house);
		}
	}

	private static int dfs(int x, int y) {
		visited[x][y] = true;
		int count = 1;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
				if (map[nx][ny] == 1 && !visited[nx][ny]) {
					count += dfs(nx, ny);
				}
			}
		}

		return count;
	}
}

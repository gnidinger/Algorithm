package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Prob2606_BFS {
	static List<Integer>[] graph;
	static boolean[] visited;
	static int count = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		graph = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}

		visited = new boolean[n + 1];

		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			graph[u].add(v);
			graph[v].add(u);
		}

		bfs(1);

		System.out.println(count - 1);
	}

	private static void bfs(int start) {
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		queue.offer(start);
		visited[start] = true;
		count++;

		while (!queue.isEmpty()) {
			int node = queue.poll();
			for (int next : graph[node]) {
				if (!visited[next]) {
					queue.offer(next);
					visited[next] = true;
					count++;
				}
			}
		}
	}
}

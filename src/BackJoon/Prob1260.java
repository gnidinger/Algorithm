package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Prob1260 {

	static List<Integer>[] graph;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());

		graph = new ArrayList[n + 1];

		for (int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			graph[x].add(y);
			graph[y].add(x);
		}

		for (int i = 1; i <= n; i++) {
			Collections.sort(graph[i]);
		}

		visited = new boolean[n + 1];
		dfs(v);
		System.out.println();

		visited = new boolean[n + 1];
		bfs(v);
	}

	private static void dfs(int node) {
		visited[node] = true;
		System.out.print(node + " ");
		for (int i : graph[node]) {
			if (!visited[i]) {
				dfs(i);
			}
		}
	}

	private static void bfs(int node) {
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		queue.offer(node);
		visited[node] = true;
		while (!queue.isEmpty()) {
			int v = queue.poll();
			System.out.print(v + " ");
			for (int i : graph[v]) {
				if (!visited[i]) {
					queue.offer(i);
					visited[i] = true;
				}
			}
		}
	}
}


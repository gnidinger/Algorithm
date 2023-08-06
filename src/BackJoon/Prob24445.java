package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Prob24445 {
	static List<Integer>[] graph;
	static boolean[] visited;
	static int[] order;
	static int count = 1;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());

		graph = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}

		visited = new boolean[n + 1];
		order = new int[n + 1];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			graph[u].add(v);
			graph[v].add(u);
		}

		for (int i = 1; i <= n; i++) {
			Collections.sort(graph[i], Collections.reverseOrder());
		}

		bfs(r);

		for (int i = 1; i <= n; i++) {
			System.out.println(order[i]);
		}
	}

	static void bfs(int node) {
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		queue.offer(node);
		visited[node] = true;
		order[node] = count++;

		while (!queue.isEmpty()) {
			int current = queue.poll();
			for (int next : graph[current]) {
				if (!visited[next]) {
					queue.offer(next);
					visited[next] = true;
					order[next] = count++;
				}
			}
		}
	}
}
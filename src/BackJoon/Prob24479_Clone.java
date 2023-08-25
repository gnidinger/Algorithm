package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Prob24479_Clone {
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
		visited = new boolean[n + 1];
		order = new int[n + 1];

		for (int i = 0; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			graph[u].add(v);
			graph[v].add(u);
		}

		for (int i = 1; i <= n; i++) {
			Collections.sort(graph[i]);
		}

		dfs(r);

		for (int i = 1; i <= n; i++) {
			System.out.println(order[i]);
		}

	}

	static void dfs(int node) {
		visited[node] = true;
		order[node] = count++;
		for (int next : graph[node]) {
			if (!visited[next]) {
				dfs(next);
			}
		}
	}
}

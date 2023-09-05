package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Prob1068 {
	static ArrayList<Integer>[] tree;
	static boolean[] visited;
	static int count = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		tree = new ArrayList[n];
		visited = new boolean[n];

		for (int i = 0; i < n; i++) {
			tree[i] = new ArrayList<>();
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		int root = -1;

		for (int i = 0; i < n; i++) {
			int parent = Integer.parseInt(st.nextToken());
			if (parent == -1) {
				root = i;
			} else {
				tree[parent].add(i);
			}
		}

		int removeNode = Integer.parseInt(br.readLine());
		if (removeNode == root) {
			System.out.println(0);
			return;
		}

		removeNode(removeNode);
		dfs(root);
		System.out.println(count);
	}

	private static void dfs(int node) {
		visited[node] = true;

		if (tree[node].isEmpty()) {
			count++;
			return;
		}

		for (int child : tree[node]) {
			if (!visited[child]) {
				dfs(child);
			}
		}
	}

	private static void removeNode(int node) {
		visited[node] = true;

		for(ArrayList<Integer> parentNode : tree) {
			parentNode.remove((Integer) node);
		}

		for (int child : tree[node]) {
			if (!visited[child]) {
				removeNode(child);
			}
		}
		tree[node].clear();
	}
}

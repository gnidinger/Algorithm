package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Prob1697 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int max = 100000;

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] distance = new int[max + 1];
		Arrays.fill(distance, -1);
		distance[n] = 0;

		ArrayDeque<Integer> queue = new ArrayDeque<>();
		queue.offer(n);

		while (!queue.isEmpty()) {

			int current = queue.poll();

			if (current == k) {
				System.out.println(distance[current]);
				return;
			}

			int[] nextPosition = {current - 1, current + 1, current * 2};

			for (int next : nextPosition) {
				if (0 <= next && next <= max && distance[next] == -1) {
					distance[next] = distance[current] + 1;
					queue.offer(next);
				}
			}
		}
	}
}

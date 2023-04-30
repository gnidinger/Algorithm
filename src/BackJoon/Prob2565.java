package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Prob2565 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] memo = new int[n];
		Arrays.fill(memo, 1);

		Map<Integer, Integer> integerMap = new TreeMap<>();

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			integerMap.put(a, b);
		}

		List<Integer> right = integerMap.entrySet().stream()
			.map(Map.Entry::getValue)
			.collect(Collectors.toList());

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (right.get(j) < right.get(i)) {
					memo[i] = Math.max(memo[i], memo[j] + 1);
				}
			}
		}

		int max = 0;

		for (int i = 0; i < n; i++) {
			max = Math.max(max, memo[i]);
		}

		System.out.println(n - max);
	}
}

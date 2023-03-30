package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

public class Prob9375 {

	static List<List<Integer>> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		List<Integer> result = new ArrayList<>();

		for (int i = 0; i < t; i++) {

			int n = Integer.parseInt(br.readLine());
			Map<String, Integer> cntMap = new HashMap<>();
			Stack<Integer> stack = new Stack<>();

			for (int j = 0; j < n; j++) {

				StringTokenizer st = new StringTokenizer(br.readLine());

				String value = st.nextToken();
				String key = st.nextToken();

				if (cntMap.containsKey(key)) {
					cntMap.replace(key, cntMap.get(key) + 1);
				} else {
					cntMap.put(key, 1);
				}
			}
			int[] arr = cntMap.values().stream()
				.mapToInt(Integer::intValue)
				.toArray();

			powerSet(stack, arr, 0);

			int sum = list.stream()
				.map(a -> a.stream()
					.reduce((x, y) -> x * y).orElse(0))
				.mapToInt(Integer::intValue)
				.sum();
			result.add(sum);
			list = new ArrayList<>();
		}
		result.forEach(System.out::println);
	}

	private static void powerSet(Stack<Integer> stack, int[] arr, int k) {

		if (k >= arr.length) { // base case
			list.add(new ArrayList<>(stack));
		} else {
			stack.push(arr[k]); // k번째 요소를 부분집합에 포함
			powerSet(stack, arr, k + 1);

			stack.pop(); // k번째 요소를 부분집합에 포함하지 않음
			powerSet(stack, arr, k + 1);
		}
	}
}
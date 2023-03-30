package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Prob11054_2 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<>();

		StringTokenizer st = new StringTokenizer(br.readLine());

		list.add(0);

		for (int i = 1; i <= n; i++) {
			int temp = Integer.parseInt(st.nextToken());
			list.add(temp);
		}

		list.add(0);


		int result = 0;

		for (int i = 0; i < n; i++) {
			List<Integer> tempListLeft = list.subList(0, i + 1);
			List<Integer> tempListRight = new ArrayList<>(list.subList(i, list.size()));
			Collections.reverse(tempListRight);
			// System.out.println(tempListLeft);
			// System.out.println(tempListRight);
			int temp = bottomUp(tempListLeft) + bottomUp(tempListRight) - 1;
			// System.out.println(temp);
			if (temp > result) {
				result = temp;
			}
		}

		System.out.println(result);
	}

	private static int bottomUp(List<Integer> list) {

		Map<Integer, Integer> integerMap = new HashMap<>();

		integerMap.put(0, 0);

		for (int i = 1; i < list.size(); i++) {

			int finalI = i;

			Map.Entry<Integer, Integer> entry = integerMap.entrySet().stream()
				.filter(integerIntegerEntry -> integerIntegerEntry.getKey() < list.get(finalI))
				.max(Map.Entry.comparingByValue())
				.orElse(new AbstractMap.SimpleEntry<>(0, 0));

			integerMap.put(list.get(i), entry.getValue() + 1);
		}

		return Collections.max(integerMap.values());
	}
}

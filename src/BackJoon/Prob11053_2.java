package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.AbstractMap;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Prob11053_2 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] arr = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Map<Integer, Integer> integerMap = new HashMap<>();

		integerMap.put(0, 0);

		for (int i = 1; i <= n; i++) {

			int finalI = i;

			Map.Entry<Integer, Integer> entry = integerMap.entrySet().stream()
				.filter(integerIntegerEntry -> integerIntegerEntry.getKey() < arr[finalI])
				.max(Map.Entry.comparingByValue())
				.orElse(new AbstractMap.SimpleEntry<>(0, 0));

			integerMap.put(arr[finalI], entry.getValue() + 1);
		}

		System.out.println(Collections.max(integerMap.values()));
	}
}

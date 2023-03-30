package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Prob2981_3 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			list.add(Integer.parseInt(br.readLine()));
		}

		int max = Collections.max(list);

		List<Integer> firstTwo = list.stream()
			.sorted()
			.limit(2)
			.collect(Collectors.toList());

		int first = IntStream.rangeClosed(2, firstTwo.get(1))
			.filter(a -> firstTwo.get(0) % a == firstTwo.get(1) % a)
			.findFirst().getAsInt();

		StringBuilder stringBuilder = new StringBuilder();

		for (int i = first; i <= max / 2; i += first) {
			int finalI = i;
			if (list.stream().map(a -> a % finalI)
				.distinct().count() == 1) {
				stringBuilder.append(i).append(" ");
			}
		}
		System.out.println(stringBuilder.toString());
	}
}
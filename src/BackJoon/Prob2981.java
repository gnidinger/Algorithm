package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Prob2981 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			list.add(Integer.parseInt(br.readLine()));
		}

		int secondMin = list.stream()
			.sorted()
			.skip(1)
			.findFirst()
			.get();

		System.out.println(secondMin);

		for (int i = 2; i <= secondMin; i++) {
			int finalI = i;
			if (list.stream().map(a -> a % finalI)
				.distinct().count() == 1) {
				System.out.println(i);
				break;
			}
		}

		StringBuilder stringBuilder = new StringBuilder();
		IntStream.rangeClosed(2, secondMin)
			.forEach(a -> {
					if (list.stream().map(b -> b % a)
						.distinct()
						.count() == 1) {
						stringBuilder.append(a).append(" ");
					}
				}
			);

		System.out.println(stringBuilder.toString());

		// IntStream.rangeClosed(2, secondMin)
		// 	.filter(a ->
		// 		list.stream()
		// 			.map(b -> b % a)
		// 			.distinct()
		// 			.count()
		// 			== 1
		// 	)
		// 	.forEach(a -> System.out.print(a + " "));
	}
}
package BackJoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Prob2477 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		List<Integer> dir = new ArrayList<>();
		List<Integer> length = new ArrayList<>();

		int n = sc.nextInt();

		for (int i = 0; i < 6; i++) {

			dir.add(sc.nextInt());
			length.add(sc.nextInt());

		}

		dir.addAll(dir);
		length.addAll(length);

		int idx = 0;

		if (dir.containsAll(List.of(3, 1, 3, 1))) {
			idx = Collections.indexOfSubList(dir, List.of(3, 1, 3, 1));
		} else if (dir.containsAll(List.of(1, 4, 1, 4))) {
			idx = Collections.indexOfSubList(dir, List.of(1, 4, 1, 4));
		} else if (dir.containsAll(List.of(4, 2, 4, 2))) {
			idx = Collections.indexOfSubList(dir, List.of(4, 2, 4, 2));
		} else if (dir.containsAll(List.of(2, 3, 2, 3))) {
			idx = Collections.indexOfSubList(dir, List.of(2, 3, 2, 3));
		}

		int area = (length.get(idx) + length.get(idx + 2))
			* (length.get(idx + 1) + length.get(idx + 3))
			- ((length.get(idx + 1)) * length.get(idx + 2));

		System.out.println(idx);
		System.out.println(area * n);

		System.out.println(dir);
		System.out.println(length);
		System.out.println(idx);
	}
}
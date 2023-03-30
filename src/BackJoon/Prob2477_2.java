package BackJoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Prob2477_2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		StringBuilder dir = new StringBuilder();
		List<Integer> length = new ArrayList<>();

		int n = sc.nextInt();

		for (int i = 0; i < 6; i++) {

			dir.append(sc.next());
			length.add(sc.nextInt());
		}

		dir.append(dir);
		length.addAll(length);

		int idx = 0;

		if (dir.toString().contains("3131")) {
			idx = dir.indexOf("3131");
		} else if (dir.toString().contains("1414")) {
			idx = dir.indexOf("1414");
		} else if (dir.toString().contains("4242")) {
			idx = dir.indexOf("4242");
		} else if (dir.toString().contains("2323")) {
			idx = dir.indexOf("2323");
		}

		int area = (length.get(idx) + length.get(idx + 2))
			* (length.get(idx + 1) + length.get(idx + 3))
			- ((length.get(idx + 1)) * length.get(idx + 2));

		System.out.println(area * n);
	}
}
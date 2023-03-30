package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Prob2580_4 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		List<List<Integer>> list = new ArrayList<>(); // 기본 리스트
		List<List<Integer>> revList = new ArrayList<>(); // Column 리스트
		List<List<Integer>> sqrList = new ArrayList<>(); // 3 X 3 사각형 리스트

		for (int i = 0; i < 9; i++) {
			List<Integer> subList = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				subList.add(Integer.parseInt(st.nextToken()));
			}
			list.add(subList);
		}

		for (int i = 0; i < 9; i++) {
			int finalI = i;
			List<Integer> colList = list.stream()
				.map(a -> a.get(finalI))
				.collect(Collectors.toList());
			revList.add(colList);
		}

		for (int i = 0; i < 9; i = i + 3) {
			for (int j = 0; j < 9; j = j + 3) {
				int finalJ = j;
				List<Integer> subList = list.subList(i, i + 3).stream()
					.map(a -> a.subList(finalJ, finalJ + 3))
					.flatMap(Collection::stream)
					.collect(Collectors.toList());
				sqrList.add(subList);
			}
		}

		sudoku(list, revList, sqrList, 0, 0);
	}

	private static void sudoku(List<List<Integer>> list, List<List<Integer>> revList, List<List<Integer>> sqrList,
		int row, int col) {

		if (col > 8) {
			sudoku(list, revList, sqrList, row + 1, 0);
			return;
		}

		if (row > 8) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					System.out.print(list.get(i).get(j) + " ");
				}
				System.out.println();
			}
			System.exit(0);
		}

		if (list.get(row).get(col) == 0) {
			for (int i = 1; i <= 9; i++) {
				if (isPossible(list, revList, sqrList, row, col, i)) {
					list.get(row).set(col, i);
					revList.get(col).set(row, i);
					sqrList.get((row / 3) * 3 + col / 3).set((row % 3) * 3 + col % 3, i);
					sudoku(list, revList, sqrList, row, col + 1);
				}
			}
			list.get(row).set(col, 0);
			revList.get(col).set(row, 0);
			sqrList.get((row / 3) * 3 + col / 3).set((row % 3) * 3 + col % 3, 0);
			return;
		}
		sudoku(list, revList, sqrList, row, col + 1);
	}

	private static boolean isPossible(
		List<List<Integer>> list, List<List<Integer>> revList,
		List<List<Integer>> sqrList, int row, int col, int value) {

		return !list.get(row).contains(value) && !revList.get(col).contains(value)
			&& !sqrList.get((row / 3) * 3 + col / 3).contains(value);
	}
}
package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Prob2580_3 {

    static List<List<Integer>> list = new ArrayList<>(); // 기본 리스트

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

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

        sudoku(list, revList, sqrList,0, 0);

    }

    private static void sudoku(List<List<Integer>> list, List<List<Integer>> revList, List<List<Integer>> sqrList, int row, int col) {

        if (col > 8) {
            sudoku(list, revList, sqrList, row + 1, 0);
            return;
        }

        if (row > 8) {
            long total = list.stream()
                    .map(a -> a.stream()
                            .mapToInt(Integer::intValue)
                            .sum())
                    .mapToInt(Integer::intValue)
                    .sum();
            if (total != 405) {
                sudoku(list, revList, sqrList, 0, 0);
            }
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(list.get(i).get(j) + " ");
                }
                System.out.println();
            }
            System.exit(0);
            return;
        }

        Set<Integer> concat = new HashSet<>();

        if (list.get(row).get(col) == 0) {
            concat.addAll(list.get(row));
            concat.addAll(revList.get(col));
            concat.addAll(sqrList.get((row / 3) * 3 + col / 3));
            if (concat.size() == 9) {
                int value = IntStream.rangeClosed(1, 9)
                        .filter(a -> !concat.contains(a))
                        .findFirst()
                        .getAsInt();
                list.get(row).set(col, value);
                revList.get(col).set(row, value);
                sqrList.get((row / 3) * 3 + col / 3).set((row % 3) * 3 + col % 3, value);
                sudoku(list, revList, sqrList, row, col + 1);
            } else {
                sudoku(list, revList, sqrList, row, col + 1);
            }
        } else {
            sudoku(list, revList, sqrList, row, col + 1);
        }
    }
}
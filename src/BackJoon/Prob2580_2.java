package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Prob2580_2 {

    static List<List<Integer>> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {

            List<Integer> subList = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                subList.add(Integer.parseInt(st.nextToken()));
            }
            list.add(subList);
        }

        sudoku(list, 0, 0);

        System.out.println();

        list.forEach(System.out::println);

    }

    private static void sudoku(List<List<Integer>> list, int row, int col) {

        if (row == 9) {
            sudoku(list, 0, col + 1);
            return;
        }

        if (col == 9) {
            long total = list.stream()
                    .map(a -> a.stream()
                            .mapToInt(Integer::intValue)
                            .sum())
                    .mapToInt(Integer::intValue)
                    .sum();
            if (total != 405) {

                List<List<Integer>> sqrList = new ArrayList<>();

                for (int i = 0; i < 9; i = i + 3) {
                    for (int j = 0; j < 9; j = j + 3) {
                        List<Integer> subList = new ArrayList<>();
                        int finalJ = j;

                        subList = list.subList(i, i + 3).stream()
                                .map(a -> a.subList(finalJ, finalJ + 3))
                                .flatMap(Collection::stream)
                                .collect(Collectors.toList());

                        sqrList.add(subList);
                    }
                }
                sqrSudoku(sqrList, 0);
            } else {
                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++) {
                        System.out.print(list.get(i).get(j) + " ");
                    }
                    System.out.println();
                }
                System.exit(0);
            }
            return;
        }

        List<Integer> rowList = list.get(row);
        List<Integer> colList = list.stream()
                .map(a -> a.get(col))
                .collect(Collectors.toList());

        IntSummaryStatistics rowSum = rowList.stream().collect(Collectors.summarizingInt(a -> a));
        IntSummaryStatistics colSum = colList.stream().collect(Collectors.summarizingInt(a -> a));

        long rowZeroCnt = rowList.stream().filter(a -> a == 0).count();
        long colZeroCnt = colList.stream().filter(a -> a == 0).count();

        if (rowZeroCnt == 1) {
            rowList.set(rowList.indexOf(0), 45 - (int) rowSum.getSum());
            list.set(row, rowList);
        }

        if (colZeroCnt == 1) {
            list.get(colList.indexOf(0)).set(col, 45 - (int) colSum.getSum());
            colList.set(colList.indexOf(0), 45 - (int) colSum.getSum());
            list.set(row, rowList);
        }

        sudoku(list, row + 1, col);
        sudoku(list, row, col + 1);
    }

    private static void sqrSudoku(List<List<Integer>> sqrList, int row) {


        if (row > 8) {
            long total = list.stream()
                    .map(a -> a.stream()
                            .mapToInt(Integer::intValue)
                            .sum())
                    .mapToInt(Integer::intValue)
                    .sum();

            if (total != 405) {
                sudoku(list, 0, 0);
            } else {

                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++) {
                        System.out.print(list.get(i).get(j) + " ");
                    }
                    System.out.println();
                }
                System.exit(0);
            }
            return;
        }

        List<Integer> rowList = sqrList.get(row);

        long rowZeroCnt = rowList.stream().filter(a -> a == 0).count();

        int listSum = rowList.stream().mapToInt(Integer::intValue).sum();

        if (rowZeroCnt == 1) {

            int idx = rowList.indexOf(0);
            int x = (row % 3) * 3 + idx % 3;
            int y = (row / 3) * 3 + (idx / 3);

            list.get(y).set(x, 45 - (int) listSum);
        }

        sqrSudoku(sqrList, row + 1);
    }
}
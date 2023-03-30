package BackJoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Prob2798 {

    private static List<List<Integer>> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int r = 3;

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        boolean[] isVisited = new boolean[n];

        combination(arr, isVisited, 0, n, r);

        int min = list.stream().map(a ->
                a.stream()
                        .mapToInt(Integer::intValue)
                        .sum())
                .distinct()
                .filter(a -> a <= m)
                .map(a -> m - a)
                .sorted()
                .findFirst()
                .orElse(-1);

        System.out.println(m - min);

    }

    static void combination(int[] arr, boolean[] isVisited, int depth, int n, int r) {

        if (r == 0) { // 다 뽑은 경우
            makeList(arr, isVisited);
            return;
        }

        if (depth != n) {
            isVisited[depth] = true;
            combination(arr, isVisited, depth + 1, n, r - 1);

            isVisited[depth] = false;
            combination(arr, isVisited, depth + 1, n, r);
        }
    }

    static void makeList(int[] arr, boolean[] isVisited) { // 배열 출력을 위한 메서드

        List<Integer> subList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {

            if (isVisited[i]) {
                subList.add(arr[i]);
            }
        }
        list.add(subList);
    }
}
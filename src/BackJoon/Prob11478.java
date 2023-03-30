package BackJoon;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Prob11478 {

    static Set<String> set = new HashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String n = sc.next();
        String[] arr = n.split("");
        int l = arr.length;

        boolean[] isVisited = new boolean[l];

        for (int i = 1; i <= l; i++) {
            combination(arr, isVisited, 0, l, i);
        }

        System.out.println(set.size());
    }

    static void combination(String[] arr, boolean[] isVisited, int depth, int n, int r) {

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

    static void makeList(String[] arr, boolean[] isVisited) { // 배열 출력을 위한 메서드

        List<String> subList = new ArrayList<>();
        String tmp = String.join("", arr);

        for (int i = 0; i < arr.length; i++) {

            if (isVisited[i]) {
                subList.add(arr[i]);
            }
        }
        String tmp2 = subList.stream()
                .map(Objects::toString)
                .collect(Collectors.joining(""));

        if (tmp.contains(tmp2)) set.add(tmp2);
    }
}
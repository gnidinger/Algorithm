package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

public class Prob14889 {

    private static List<List<Integer>> list = new ArrayList<>();
    private static List<List<Integer>> midList = new ArrayList<>();
    private static int value = 0;
    private static Set<Integer> result = new HashSet<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n]; // 중복 조합 뽑을 사람 번호

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            List<Integer> subList = new ArrayList<>();
            arr[i] = i;
            for (int j = 0; j < n; j++) {
                subList.add(Integer.parseInt(st.nextToken()));
            }
            list.add(subList);
        }
        boolean[] isVisited = new boolean[list.size()]; // 사람 수와 동일

        comb(arr, isVisited, 0, arr.length, arr.length / 2); // n개중 n/2개를 조합으로 뽑는 경우

        for (int i = 0; i < midList.size(); i++) {

            int finalI = i;
            int[] opArr = IntStream.range(0, n)
                    .filter(a -> !midList.get(finalI).contains(a))
                    .toArray();

            int[] combArr = midList.get(i).stream()
                    .mapToInt(Integer::intValue)
                    .toArray();

            int tmp;

            value = 0;

            isVisited = new boolean[combArr.length];

            nextComb(combArr, isVisited, 0, combArr.length, 2);

            tmp = value;

            value = 0;

            isVisited = new boolean[opArr.length];

            nextComb(opArr, isVisited, 0, opArr.length, 2);

            result.add(Math.abs(tmp - value));
        }

        System.out.println(Collections.min(result));
    }

    static void comb(int[] arr, boolean[] isVisited, int depth, int n, int r) {

        if (r == 0) { // base condition
            print(arr, isVisited);
            return;
        }
        if (depth == n) {
            return;
        } else {
            isVisited[depth] = true;
            comb(arr, isVisited, depth + 1, n, r - 1); // 재귀함수 호출

            isVisited[depth] = false;
            comb(arr, isVisited, depth + 1, n, r);
        }
    }

    static void print(int[] arr, boolean[] isVisited) { // 배열 출력을 위한 메서드

        List<Integer> combList = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (isVisited[i]) {
                combList.add(arr[i]);
            }
        }
        midList.add(combList);
    }

    static void nextComb(int[] arr, boolean[] isVisited, int depth, int n, int r) {

        if (r == 0) { // base condition
            calc(arr, isVisited);
            return;
        }
        if (depth == n) {
            return;
        } else {
            isVisited[depth] = true;
            nextComb(arr, isVisited, depth + 1, n, r - 1); // 재귀함수 호출

            isVisited[depth] = false;
            nextComb(arr, isVisited, depth + 1, n, r);
        }
    }

    static void calc(int[] arr, boolean[] isVisited) { // 배열 출력을 위한 메서드

        List<Integer> combList = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (isVisited[i]) {
                combList.add(arr[i]);
            }
        }
        value = value + list.get(combList.get(0)).get(combList.get(1))
                + list.get(combList.get(1)).get(combList.get(0));
    }
}
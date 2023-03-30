package BackJoon;

import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Prob1932_2 {

    private static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            topDown(arr, n - 1, i);
        }

        System.out.println(Collections.max(set));
    }

    private static int topDown(int[][] arr, int i, int j) {

       int[][] memo = new int[arr.length + 1][arr.length + 1];

        if (i == 0) return arr[0][0];
        if (j == 0) { // j == 0 이면 나머지 더해 리턴
                int zeroSum = 0;
                for (int a = i; a >= 0; a--) {
                    zeroSum += arr[a][0];
                }
                return zeroSum;
        }

        memo[0][0] = arr[0][0]; // 초기값 설정

        if (memo[i][j] == 0) {
                memo[i][j] = Math.max(topDown(arr, i - 1, j),
                        topDown(arr, i - 1, j - 1))
                        + arr[i][j];
        }

        set.add(memo[i][j]);
        return memo[i][j];
    }
}
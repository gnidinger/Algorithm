package BackJoon;

import java.util.Scanner;

public class Prob1932_3 {
    private static int[][] memo;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        memo = new int[arr.length + 1][arr.length + 1];

        for (int i = 0; i < arr.length; i++) {
            memo[arr.length - 1][i] = arr[arr.length - 1][i];
        }

        System.out.println(bottomUp(arr, 0, 0));
    }

    private static int bottomUp(int[][] arr, int i, int j) {


        if (i == arr.length - 1) return memo[i][j];

        if (memo[i][j] == 0) {
            memo[i][j] = Math.max(bottomUp(arr, i + 1, j), bottomUp(arr, i + 1, j + 1)) + arr[i][j];
        }

        return memo[i][j];
    }
}
package BackJoon;

import java.util.Scanner;

public class Prob11054 {
    private static int[] memo;
    private static int[] memo2;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        memo = new int[arr.length + 1];
        memo2 = new int[arr.length + 1];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int max = 1;

        for (int i = 0; i < n; i++) {
            max = Math.max(max, topDown(i, arr) + topDown2(i, arr));
        }

        System.out.println(max - 1);
    }

    static int topDown(int n, int[] arr) {

        if (memo[n] == 0) {
            memo[n] = 1;

            for (int i = n - 1; i >= 0; i--) {
                if (arr[i] < arr[n]) {
                    memo[n] = Math.max(memo[n], 1 + topDown(i, arr));
                }
            }
        }
        return memo[n];
    }

    static int topDown2(int n, int[] arr) {

        if (memo2[n] == 0) {
            memo2[n] = 1;

            for (int i = n + 1; i < arr.length; i++) {
                if (arr[i] < arr[n]) {
                    memo2[n] = Math.max(memo2[n], 1 + topDown2(i, arr));
                }
            }
        }
        return memo2[n];
    }
}
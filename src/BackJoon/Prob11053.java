package BackJoon;

import java.util.Scanner;

public class Prob11053 {
    private static int[] memo;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        memo = new int[arr.length + 1];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int max = 1;

        for (int i = 0; i < n; i++) {
            max = Math.max(max, topDown(i, arr));
        }
        System.out.println(max);
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
}
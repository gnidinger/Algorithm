package BackJoon;

import java.util.Scanner;

public class Prob2579 {
    private static int[] memo;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n + 1];
        memo = new int[arr.length];

        for (int i = 0; i < n; i++) {
            arr[i + 1] = sc.nextInt();
        }

        System.out.println(bottomUp(arr, n));
    }

    private static int bottomUp(int[] arr, int i) {

        memo[1] = arr[1];

        if (i >= 2) {
            memo[2] = arr[1] + arr[2];
        }

        for (int j = 3; j <= arr.length - 1; j++){
            memo[j] = arr[j] + Math.max(memo[j - 2], arr[j - 1] + memo[j - 3]);
        }

        return memo[i];

    }
}
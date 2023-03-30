package BackJoon;

import java.io.IOException;
import java.util.Scanner;

public class Prob24416 {

    private static int times = 0;

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(topDown(n) + " " + bottomUp(n));
    }

    private static long topDown(int n) {

        long[] memo = new long[n + 1];

        if (n == 1 || n == 2) return memo[n] = 1;

        if (memo[n] != 0) return memo[n];
        else {
            memo[n] = topDown(n - 1) + topDown(n - 2);
        }

        return memo[n];
    }

    private static long bottomUp(int n) {

        long[] memo = new long[n + 1];
        memo[1] = 1;
        memo[2] = 1;

        for (int i = 3; i <= n; i++) {
            times++;
            memo[i] = memo[i - 1] + memo[i - 2];
        }

        return times;
    }
}
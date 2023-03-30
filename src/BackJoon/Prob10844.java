package BackJoon;

import java.util.Scanner;

public class Prob10844 {

    private static long[][] memo;
    private static long result = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        memo = new long[n + 1][10];

        for (int i = 1; i < 10; i++) {
            memo[1][i] = 1;
        }

        bottomUp(n);

        for (int i = 0; i < 10; i++) {
            result += memo[n][i];
        }

        System.out.println(result % 1_000_000_000);

    }

    private static void bottomUp(int n) {


        for (int i = 2; i < n + 1; i++) {

            for (int j = 0; j < 10; j++) {

                if (j == 0) {
                    memo[i][0] = memo[i - 1][1] % 1_000_000_000;
                }

                else if (j == 9) {
                    memo[i][9] = memo[i - 1][8] % 1_000_000_000;
                }

                else {
                    memo[i][j] = (memo[i - 1][j - 1] + memo[i - 1][j + 1]) % 1_000_000_000;
                }
            }
        }
    }
}
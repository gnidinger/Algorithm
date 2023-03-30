package BackJoon;

import java.util.Scanner;

public class Prob1463_2 {

    private static Integer[] memo;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        memo = new Integer[n + 1];
        memo[0] = memo[1] = 0;
//        memo[2] = memo[3] = 1;

        System.out.println(topDown(n));

    }

    private static int topDown(int n) {

        if (memo[n] == null) {
            if (n % 3 == 0 && n % 2 == 0) memo[n] = 1 + Math.min(Math.min(topDown(n / 2), topDown(n / 3)), topDown(n - 1));
            else if (n % 3 == 0 && n % 2 != 0) memo[n] = 1 + Math.min(topDown(n - 1), topDown(n / 3));
            else if (n % 3 != 0 && n % 2 == 0) memo[n] = 1 + Math.min(topDown(n - 1), topDown(n / 2));
            else memo[n] = 1 + topDown(n - 1);
        }

        return memo[n];
    }
}
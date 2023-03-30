package BackJoon;

import java.util.Scanner;

public class Prob1463 {

    private static int[] memo;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        memo = new int[n + 1];

        System.out.println(topDown(n));

    }

    private static int topDown(int n) {


       if (n == 1 | n == 2 | n == 3) {
           return memo[n] = 1;
       }

       if (memo[n] == 0) {
           if (n % 3 != 0 && n % 2 == 0) memo[n] = 1 + Math.min(topDown(n - 1), topDown(n / 2));
           else if (n % 3 == 0 && n % 2 != 0) memo[n] = 1 + Math.min(topDown(n - 1), topDown(n / 3));
           else if (n % 3 == 0 && n % 2 == 0) memo[n] = 1 + Math.min(Math.min(topDown(n - 1), topDown(n / 3)), topDown(n / 2));
           if (n % 3 != 0 && n % 2 != 0) memo[n] = 1 + topDown(n - 1);
       }

        return memo[n];
    }
}
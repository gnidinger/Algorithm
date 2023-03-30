package BackJoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Prob9461 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Long> list = new ArrayList<>();

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            list.add(bottomUp(sc.nextInt()));
        }

        list.forEach(System.out::println);
    }


    private static long bottomUp(int n) {

        long[] memo = new long[n + 4];
        memo[1] = 1;
        memo[2] = 1;
        memo[3] = 1;
        memo[4] = 2;

        for (int i = 4; i <= n; i++) {
            memo[i] = (memo[i - 2] + memo[i - 3]);
        }

        return memo[n];
    }
}
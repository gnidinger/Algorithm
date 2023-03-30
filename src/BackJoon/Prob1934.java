package BackJoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Prob1934 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < t; i++) {

            int n = sc.nextInt();
            int m = sc.nextInt();
            int gcd = gcd(Math.max(n, m), Math.min(n, m));

            list.add(n * m / gcd);
        }
        list.forEach(System.out::println);
    }
    private static int gcd(int a, int b) {
        if (a % b == 0) return b;
        return gcd(b, a % b);
    }
}
package BackJoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Prob3036 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int a = sc.nextInt();
        List<String> list = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {

            int b = sc.nextInt();

            int gcd = gcd(Math.max(a, b), Math.min(a, b));

            list.add(a / gcd + "/" + b / gcd);
        }

        list.forEach(System.out::println);
    }
    private static int gcd(int a, int b) {
        if (a % b == 0) return b;
        return gcd(b, a % b);
    }
}
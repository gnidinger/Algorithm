package BackJoon;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Prob2609 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int gcd = IntStream.rangeClosed(1, Math.max(n, m))
                .filter(a -> n % a == 0 && m % a == 0)
                .max()
                .getAsInt();

        System.out.println(gcd);
        System.out.println(n * m / gcd);
    }
}
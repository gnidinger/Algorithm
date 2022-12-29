package BackJoon;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Prob1929Stream {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        IntStream.rangeClosed(m, n)
                .filter(a -> a > 1)
                .filter(a ->
                        IntStream.rangeClosed(2, (int) Math.sqrt(a))
                                .allMatch(b -> a % b != 0))
                .forEach(System.out::println);
    }
}
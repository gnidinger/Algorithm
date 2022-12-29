package BackJoon;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Prob2739Stream {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        IntStream.rangeClosed(1, 9)
                .forEach(a -> System.out.printf("%d * %d = %d%n", n, a, n * a));
    }
}

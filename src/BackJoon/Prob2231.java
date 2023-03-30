package BackJoon;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Prob2231 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int min = IntStream.rangeClosed(1, n)
                .filter(a ->
                        a + String.valueOf(a).chars()
                                .map(b -> b - 48)
                                .sum() == n)
                .sorted()
                .findFirst()
                .orElse(0);

        System.out.println(min);
    }
}
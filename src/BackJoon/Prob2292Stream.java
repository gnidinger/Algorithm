package BackJoon;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Prob2292Stream {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int result = IntStream.rangeClosed(1, 31623)
                .filter(x -> 1 + 3 * (Math.pow(x, 2) - x) >= n)
                .min().getAsInt();

        System.out.println(result);
    }
}
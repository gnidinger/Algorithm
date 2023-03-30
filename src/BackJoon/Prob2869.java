package BackJoon;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Prob2869 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int v = sc.nextInt();

        int result = IntStream.rangeClosed(0, 1_000_000_000)
                .filter(i -> a + (a - b) * i > v )
                .min().getAsInt();

        System.out.println(result);

    }
}
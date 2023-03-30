package BackJoon;

import java.io.IOException;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Prob1676 {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        long five = IntStream.rangeClosed(0, n)
                .filter(a -> a % 5 == 0)
                .count();

        long tf = IntStream.rangeClosed(25, n)
                .filter(a -> a % 25 == 0)
                .count();

        long htf = IntStream.rangeClosed(125, n)
                .filter(a -> a % 125 == 0)
                .count();

        System.out.println(five + tf + htf - 1);

    }
}
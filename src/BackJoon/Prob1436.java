package BackJoon;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Prob1436 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        String num = IntStream.rangeClosed(1, 3000000)
                .mapToObj(Integer::toString)
                .filter(a -> a.contains("666"))
                .skip(n - 1)
                .findFirst()
                .get();

        System.out.println(num);
    }
}
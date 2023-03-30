package BackJoon;

import java.util.IntSummaryStatistics;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Prob2581Stream_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        IntSummaryStatistics result = IntStream.rangeClosed(m, n)
                .filter(a -> a > 1)
                .filter(a -> IntStream.rangeClosed(2, (int)Math.sqrt(a)).allMatch(b -> a % b != 0))
                .boxed()
                .collect(Collectors.summarizingInt(a -> a));

        if (result.getCount() == 0) System.out.println(-1);
        else {
            System.out.println(result.getSum());
            System.out.println(result.getMin());
        }
    }
}
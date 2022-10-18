import java.util.OptionalInt;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Prob2581Stream {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        int result1 = IntStream.rangeClosed(m, n)
                .filter(a -> a > 1)
                .filter(a -> IntStream.rangeClosed(2, (int)Math.sqrt(a)).allMatch(b -> a % b != 0))
                .sum();

        OptionalInt result2 = IntStream.rangeClosed(m, n)
                .filter(a -> a > 1)
                .filter(a -> IntStream.rangeClosed(2, (int)Math.sqrt(a)).allMatch(b -> a % b != 0))
                .min();

        if(result2 == OptionalInt.empty()) System.out.println(-1);
        else{
            System.out.println(result1);
            System.out.println(result2.getAsInt());
        }
    }
}
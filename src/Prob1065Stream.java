import java.util.Scanner;
import java.util.stream.IntStream;

public class Prob1065Stream {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        if (n < 100) System.out.println(n);

        else {
            long result = IntStream.rangeClosed(100, n)
                    .filter(a -> (a / 100 - (a / 10) % 10) == ((a / 10) % 10 - a % 10))
                    .count();

            System.out.println(result + 99);
        }
    }
}
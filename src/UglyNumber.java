import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class UglyNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<Integer> list = IntStream.rangeClosed(1, n)
                .filter(a -> a % 2 == 0 || a % 3 == 0 || a % 5 == 0)
                .boxed()
                .collect(Collectors.toList());

        System.out.println(list);

    }
}

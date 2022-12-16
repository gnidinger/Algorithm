import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Prob11720Stream {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String x = sc.next();

        List<String> list = new ArrayList<>();

        list.add(x);

        int result = list.stream()
                .flatMap(a -> Arrays.stream(a.split("")))
                .mapToInt(Integer::parseInt)
                .sum();

        System.out.println(result);
    }
}




//    Scanner sc = new Scanner(System.in);
//
//    int n = sc.nextInt();
//    BigInteger x = sc.nextBigInteger();
//
//    List<Integer> list = new ArrayList<>();
//
//        for(int i = 0; i < n; i++) {
//        list.add((x.remainder(BigInteger.TEN)).intValue());
//        x = x.divide(BigInteger.TEN);
//        }
//
//        int result = list.stream()
//        .mapToInt(a -> a)
//        .sum();
//
//        System.out.println(result);
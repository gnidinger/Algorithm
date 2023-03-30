package BackJoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Prob11653_2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<Integer> result = new ArrayList<>();
        List<Integer> candiPrime = new ArrayList<>();

        for (int i = 2; i <= n; i++) {
            candiPrime.add(i);
        }

        while (candiPrime.size() != 0) {

            if (candiPrime.get(0) > Math.sqrt(n)) {
                if (result.size() == 0) {
                    System.out.println(n);
                    System.exit(0);
                } else {
                    result.forEach(System.out::println);
                    System.exit(0);
                }
            }

            if (n % candiPrime.get(0) == 0) {
                n = n / candiPrime.get(0);
                result.add(candiPrime.get(0));
            } else {
                int den = candiPrime.get(0);
                candiPrime = candiPrime.stream()
                        .filter(a -> a % den != 0)
                        .collect(Collectors.toList());
            }
        }
        result.forEach(System.out::println);
    }
}
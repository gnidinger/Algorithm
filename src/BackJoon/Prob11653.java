package BackJoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Prob11653 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<List<Integer>> list = new ArrayList<>();

        List<Integer> primeList = IntStream.rangeClosed(2, n)
                .filter(a ->
                        IntStream.rangeClosed(2, (int) Math.sqrt(a))
                                .allMatch(b -> a % b != 0))
                .boxed()
                .collect(Collectors.toList());

        while (n != 1) {

            List<Integer> subList = new ArrayList<>();

            for (int i = 0; i < primeList.size(); i++) {

                int num = primeList.get(i);

                if (n % num == 0) {
                    subList.add(num);
                    n = n / num;
                }
            }
            list.add(subList);
        }

        List<Integer> result = list.stream()
                .flatMap(List::stream)
                .sorted()
                .collect(Collectors.toList());

        if (result.isEmpty()) System.out.println();
        else {
            for (Integer integer : result) {
                System.out.println(integer);
            }
        }
    }
}
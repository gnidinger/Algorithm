package BackJoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Prob5597Stream {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> list = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        for (int i = 1; i <= 30; i++) {
            list.add(i);
        }

        for (int i = 0; i < 28; i++) {
            list2.add(sc.nextInt());
        }

        List<Integer> result = list.stream()
                .filter(a -> list2.stream().noneMatch(Predicate.isEqual(a)))
                .sorted().collect(Collectors.toList());

        System.out.println(result.get(0));
        System.out.println(result.get(1));
    }
}
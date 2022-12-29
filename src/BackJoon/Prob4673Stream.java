package BackJoon;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Prob4673Stream {
    public static void main(String[] args) {

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        for (int i = 1; i <= 10000; i++) {
            list1.add(i);
        }

        for (int i = 1; i <= 10000; i++) {
            list2.add(i +
                    i % 10 +
                    (i % 100) / 10 +
                    (i % 1000) / 100 +
                    (i % 10000) / 1000);
        }

        list1.stream()
                .filter(a -> list2.stream()
                        .distinct()
                        .filter(b -> b <= 10000)
                        .noneMatch(Predicate.isEqual(a)))
                .sorted()
                .forEach(System.out::println);
    }
}
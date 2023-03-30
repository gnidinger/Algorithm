package BackJoon;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Prob2108 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<Integer> list = new ArrayList<>();
        List<Integer> countList = new ArrayList<>();

        for (int i = 0; i < 8001; i++) {
            countList.add(0);
        }

        for (int i = 0; i < n; i++) {

            int a = sc.nextInt(); // 절대값이 4000이라고 했으니 음수 보정

            if (list.contains(a)) {
                countList.set(a + 4000, countList.get(a + 4000) + 1);
                list.add(a);
            } else {
                countList.set(a + 4000, 1);
                list.add(a);
            }
        }

        int mode = 0;

        List<Integer> sortedList = countList.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        if (sortedList.get(0).equals(sortedList.get(1))) {

            mode = IntStream.rangeClosed(0, 8000)
                    .filter(a -> Objects.equals(countList.get(a), sortedList.get(1)))
                    .map(a -> a - 4000)
                    .distinct()
                    .skip(1)
                    .findFirst()
                    .getAsInt();

        } else {
            mode = countList.indexOf(sortedList.get(0)) - 4000;
        }

        int median = list.stream().sorted().collect(Collectors.toList()).get(n / 2);

        IntSummaryStatistics stat = list.stream()
                .collect(Collectors.summarizingInt(a -> a));

        System.out.println(Math.round(stat.getAverage()));
        System.out.println(median);
        System.out.println(mode);
        System.out.println(stat.getMax() - stat.getMin());


    }
}
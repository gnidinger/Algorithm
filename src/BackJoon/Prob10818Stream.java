package BackJoon;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Prob10818Stream {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        IntSummaryStatistics statistics =
                list.stream()
                        .collect(Collectors.summarizingInt(a -> a));

        System.out.print(statistics.getMin() + " " + statistics.getMax());
    }
}

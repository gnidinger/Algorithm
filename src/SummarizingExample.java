import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class SummarizingExample {
    public static void main(String[] args) {

        List<Integer> list = List.of(2, 3, 5, 7, 11, 13, 17, 19);

        IntSummaryStatistics statistics =
                list.stream()
                        .collect(Collectors.summarizingInt(a -> a));

        System.out.println(statistics);
        System.out.println();
        System.out.println("Count: " + statistics.getCount());
        System.out.println("Summation: " + statistics.getSum());
        System.out.println("Average: " + statistics.getAverage());
        System.out.println("Max Value: " + statistics.getMax());
        System.out.println("Min Value: " + statistics.getMin());

        System.out.println();

    }
}

package Programmers;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.stream.Collectors;

class FindMinMax {
    public String solution(String s) {
        String answer = "";

        IntSummaryStatistics stat = Arrays.stream(s.split(" "))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.summarizingInt(a -> a));

        answer = String.valueOf(stat.getMin() + " " + stat.getMax());

        return answer;
    }
}
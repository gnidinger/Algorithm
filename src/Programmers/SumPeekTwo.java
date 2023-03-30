package Programmers;

import java.util.Arrays;
import java.util.stream.IntStream;

class SumPeekTwo {
    public int[] solution(int[] numbers) {
        int[] answer = {};

        answer = IntStream.range(0, numbers.length)
                .mapToObj(a ->
                        IntStream.range(0, numbers.length)
                                .filter(b -> b != a)
                                .map(b -> numbers[a] + numbers[b])
                                .toArray())
                .flatMapToInt(Arrays::stream)
                .distinct()
                .sorted()
                .toArray();

        return answer;
    }
}
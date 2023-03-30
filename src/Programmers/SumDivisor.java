package Programmers;

import java.util.stream.IntStream;

class SumDivisor {
    public int solution(int left, int right) {
        int answer = 0;

        int pos = IntStream.rangeClosed(left, right)
                .filter(a ->
                        IntStream.rangeClosed(1, a)
                                .filter(b -> a % b == 0)
                                .count() % 2 == 0
                )
                .sum();

        int neg = IntStream.rangeClosed(left, right)
                .filter(a ->
                        IntStream.rangeClosed(1, a)
                                .filter(b -> a % b == 0)
                                .count() % 2 == 1
                )
                .sum();

        answer = pos - neg;

        return answer;
    }
}
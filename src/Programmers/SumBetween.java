package Programmers;

import java.util.stream.LongStream;

class SumBetween {
    public long solution(int a, int b) {
        long answer = 0;

        answer = LongStream.rangeClosed(Math.min(a, b), Math.max(a, b))
                .sum();

        return answer;
    }
}
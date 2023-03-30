package Programmers;

import java.util.stream.IntStream;

class Divisor {
    public int solution(int n) {
        int answer = 0;

        answer = IntStream.rangeClosed(1, n)
                .filter(a -> n % a == 0)
                .sum();

        return answer;
    }
}
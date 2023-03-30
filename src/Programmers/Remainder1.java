package Programmers;

import java.util.stream.IntStream;

class Remainder1 {
    public int solution(int n) {
        int answer = 0;

        answer = IntStream.range(2, n)
                .filter(a -> n % a == 1)
                .min().getAsInt();

        return answer;
    }
}
package Programmers;

import java.util.stream.IntStream;

class FindPrimeNumber {
    public int solution(int n) {
        int answer = 0;

        answer = (int) IntStream.rangeClosed(2, n)
                .filter(a ->
                        a > 1 &&
                                IntStream.rangeClosed(2, (int) Math.sqrt(a))
                                        .allMatch(b -> a % b != 0))
                .count();


        return answer;
    }
}
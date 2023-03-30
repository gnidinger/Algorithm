package Programmers;

import java.util.Arrays;

class SumDoNotExist {
    public int solution(int[] numbers) {
        int answer = -1;

        int sum = Arrays.stream(numbers)
                .sum();

        answer = 45 - sum;

        return answer;
    }
}

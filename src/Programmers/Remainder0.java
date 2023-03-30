package Programmers;

import java.util.Arrays;

class Remainder0 {
    public int[] solution(int[] arr, int divisor) {
        int[] answer = {};

        answer = Arrays.stream(arr)
                .filter(a -> a % divisor == 0)
                .sorted()
                .toArray();

        if (answer.length == 0) answer = new int[]{-1};

        return answer;
    }
}
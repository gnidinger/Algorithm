package Programmers;

import java.util.Arrays;

class Average {
    public double solution(int[] arr) {
        double answer = 0;

        answer = Arrays.stream(arr)
                .average().getAsDouble();

        return answer;
    }
}
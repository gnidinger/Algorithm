package Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

class ReverseN {
    public int[] solution(long n) {
        int[] answer = {};

        String x = Long.toString(n);

        List<String> list = new ArrayList<>();
        list.add(x);

        int[] arr = list.stream()
                .flatMap(a -> Arrays.stream(a.split("")))
                .mapToInt(Integer::parseInt)
                .toArray();

        answer = IntStream.iterate(arr.length - 1, i -> i >= 0, i -> i - 1)
                .map(i -> arr[i])
                .toArray();

        return answer;
    }
}
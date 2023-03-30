package Programmers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

class StringReverseOrder {
    public String solution(String s) {
        String answer = "";

        answer = Arrays.stream(s.split(""))
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.joining());

        return answer;
    }
}
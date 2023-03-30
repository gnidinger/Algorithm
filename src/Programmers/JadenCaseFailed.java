package Programmers;

import java.util.Arrays;
import java.util.stream.Collectors;

class JadenCaseFailed {
    public String solution(String s) {
        String answer = "";

        answer = Arrays.stream(s.split(""))
                .map(String::toLowerCase)
                .filter(a -> a.length() != 0)
                .map(a -> Character.toUpperCase(a.charAt(0)) +
                        Arrays.stream(a.split(""))
                                .skip(1)
                                .collect(Collectors.joining()))
                .reduce("", (a, b) -> a + " " + b)
                .trim();

        return answer;
    }
}
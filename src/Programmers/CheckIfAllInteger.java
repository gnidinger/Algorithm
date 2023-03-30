package Programmers;

import java.util.ArrayList;
import java.util.List;

class CheckIfAllInteger {
    public boolean solution(String s) {
        boolean answer = true;

        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < s.length(); i ++) {
            list.add(s.charAt(i) - 0);
        }

        if (s.length() == 4 || s.length() == 6) {
            answer =list.stream()
                    .allMatch(a -> (48 <= a && a <= 57));
        } else answer = false;

        return answer;
    }
}
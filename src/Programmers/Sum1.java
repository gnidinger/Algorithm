package Programmers;

import java.util.ArrayList;
import java.util.List;

public class Sum1 {
    public int solution(int n) {
        int answer = 0;

        int a = (int)(Math.log10(n)+1);

        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < a; i++) {
            list.add(n % 10);
            n /= 10;
        }

        answer = list.stream()
                .mapToInt(x -> x)
                .sum();

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        return answer;
    }
}

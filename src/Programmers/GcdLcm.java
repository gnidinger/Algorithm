package Programmers;

import java.util.stream.IntStream;

class GcdLcm {
    public int[] solution(int n, int m) {

        int[] answer = {};

        int gcd = IntStream.rangeClosed(1, Math.min(n, m))
                .filter(a -> n % a == 0 && m % a == 0)
                .max().getAsInt();

        int lcm = gcd * (n / gcd) * (m /gcd);

        answer = new int[]{gcd, lcm};

        return answer;
    }
}
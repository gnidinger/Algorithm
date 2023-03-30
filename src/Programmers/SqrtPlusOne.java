package Programmers;

class SqrtPlusOne {
    public long solution(long n) {
        long answer = 0;

        double m = Math.sqrt(n);
        double l = (int) Math.ceil(m);
        if (m == l) {
            answer = (long) Math.pow(l + 1, 2);
        } else answer = -1;
        return answer;
    }
}
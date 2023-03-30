package Programmers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MagicalElevator_5 {

    private static int[] memo;
    private static List<Integer> list = new ArrayList<>();
    private static int[] button;
    static int cnt = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        int n = Integer.parseInt(str);
        int digit = str.length(); // 자리수
        memo = new int[n + 1];
        list.add(1);
        memo[0] = 0;

        button = new int[2 * (digit + 1)];

        for (int i = digit; i >= 0; i--) { // 자리수 + 1 까지 버튼 {-100, -10, -1, 1, 10, 100}
            button[digit - i] = (int) -Math.pow(10, i);
            button[digit + i + 1] = (int) Math.pow(10, i);
        }

        for (int i = 0; i < 10000; i++) {

        }
        System.out.println(recur(button, n, digit + 1));
    }

    static int recur(int[] button, int n, int pow) {

        cnt++;

        if (n % 10 == 0) return cnt;

        memo[1] = 1;

//        if (1 <= n && n <= 10) {
//            memo[n] = memo[11 - n] = n;
//        }

        List<Integer> subList = new ArrayList<>();
        for (int i : button) {
            for (Integer integer : list) {
                if (i + integer >= 0) {
                    subList.add(i + integer);
                }
            }
        }
        list.addAll(subList);

        list = list.stream()
                .distinct()
                .collect(Collectors.toList());

        if (list.contains(n)) memo[n] = cnt;

        else {
            memo[n] = Math.min(recur(button, n, pow), recur(button, (int) (n % Math.pow(10, pow - 1)), pow) + recur(button, (int) (n / Math.pow(10, pow - 1)), pow - 1));
        }

        return memo[n];
    }
}

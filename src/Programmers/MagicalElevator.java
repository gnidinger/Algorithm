package Programmers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MagicalElevator {

    private static int[] memo;
    private static List<Integer> list = new ArrayList<>();
    private static int[] button;
    static int cnt = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        int n = Integer.parseInt(str);
        int digit = str.length(); // 자리수
        memo = new int[1];
        memo[0] = 0;

        button = new int[2 * (digit + 1)];

        for (int i = digit; i >= 0; i--) { // 자리수 + 1 까지 버튼 {-100, -10, -1, 1, 10, 100}
            button[digit - i] = (int) -Math.pow(10, i);
            button[digit + i + 1] = (int) Math.pow(10, i);
        }

        for (int i = 0; i < 10000; i++) {

        }
        recur(button, n);
    }

    static void recur(int[] button, int n) {

        cnt++;

        for (int i : button) {
            for (int j = 0; j < memo.length; j++) {
                if (i + memo[j] >= 0) {
                    list.add(i + memo[j]);
                }
            }
        }

        if (list.contains(n)) System.out.println(cnt);
        else {
            memo = list.stream()
                    .distinct()
//                    .filter(a -> a >= 0)
                    .filter(a -> a >= button[button.length - 3])
                    .filter(a -> a < button[button.length - 1] * 10)
                    .mapToInt(Integer::intValue)
                    .toArray();
            recur(button, n);
        }
    }
}

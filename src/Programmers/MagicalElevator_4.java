package Programmers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MagicalElevator_4 {

    private static int[] memo;
    private static List<Integer> list = new ArrayList<>();
    private static int[] button;
    static int cnt = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        int n = Integer.parseInt(str);
        int digit = str.length(); // 자리수
        int pow = (int) Math.pow(10, digit);
        memo = new int[n + 1];
        list.add(0);
        memo[0] = 0;

        button = new int[2 * (digit + 1)];

        for (int i = digit; i >= 0; i--) { // 자리수 + 1 까지 버튼 {-100, -10, -1, 1, 10, 100}
            button[digit - i] = (int) -Math.pow(10, i);
            button[digit + i + 1] = (int) Math.pow(10, i);
        }

        for (int i = 0; i < 10000; i++) {

        }
        System.out.println(recur(button, n));
    }

    static int recur(int[] button, int n) {

        cnt++;

        if (n % 10 == 0) return cnt;

        memo[1] = 1;

        int[] strArr = String.valueOf(n).chars().map(a -> a - 48).toArray();

        int answer = 0;

            for(int i = 0; i < strArr.length; i++) {
                if (strArr[i] <= 5) answer += strArr[i];
                else if (strArr[i] > 5) answer += 11 - strArr[i];
            }


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
            memo[n] = Math.min(answer, recur(button, (int) (n % Math.pow(10, strArr.length - 1))) + recur(button, (int) (n / Math.pow(10, strArr.length - 1))));
        }

        return memo[n];
    }
}

package Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MagicalElevator_3 {

    private static int[] memo;
    private static List<Integer> list = new ArrayList<>();
    private static int[] button;
    static int cnt = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        int[] strArr = str.chars().map(a -> a - 48).toArray();
        int n = Integer.parseInt(str);
        int digit = str.length(); // 자리수
        memo = new int[1];
        memo[0] = 0;

        button = new int[]{-100, -10, -1, 1, 10, 100};
//        button = new int[2 * (digit + 1)];
//
//        for (int i = digit; i >= 0; i--) { // 자리수 + 1 까지 버튼 {-100, -10, -1, 1, 10, 100}
//            button[digit - i] = (int) -Math.pow(10, i);
//            button[digit + i + 1] = (int) Math.pow(10, i);
//        }

        int answer = 0;
        if (n <= 100) answer = recur(button, n);
        else {
            for(int i = 0; i < strArr.length - 2; i++) {
                if (strArr[i] <= 5) answer += strArr[i];
                else if (strArr[i] > 5) answer += 11 - strArr[i];
            }
            answer += recur(button, n % 100);
        }

        System.out.println(answer);

        System.out.println(Arrays.toString(strArr));


//        for (int i = 0; i < 10000; i++) {
//            cnt = 0;
//            list = new ArrayList<>();
//            memo = new int[1];
//            int a = recur(button, 10 * i + 1);
//            cnt = 0;
//            list = new ArrayList<>();
//            memo = new int[1];
//            int b = recur(button, 10 * i + 10);
//            System.out.print(a - b + " ");
//        }
//        cnt = 0;
//        System.out.println(recur(button, 31));
//        cnt = 0;
//        list = new ArrayList<>();
//        memo = new int[1];
//        System.out.println(recur(button, 40));
    }

    static int recur(int[] button, int n) {

        cnt++;

        for (int i : button) {
            for (int j = 0; j < memo.length; j++) {
                if (i + memo[j] >= 0) {
                    list.add(i + memo[j]);
                }
            }
        }

        if (list.contains(n)) return cnt;
        else {
            memo = list.stream()
                    .distinct()
                    .mapToInt(Integer::intValue)
                    .toArray();
            recur(button, n);
        }
        return cnt;
    }
}

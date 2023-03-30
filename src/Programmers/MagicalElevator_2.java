package Programmers;

import java.util.Scanner;

public class MagicalElevator_2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        int n = Integer.parseInt(str);
        int digit = str.length(); // 자리수

        int center = Integer.parseInt("5".repeat(digit));
        int centerValue = 0;

        if (digit == 1) centerValue = 5;
        else if (digit == 2) centerValue = 10;
        else if (digit > 2) {
            centerValue = 10 + 4 * (digit - 2);
        }

        int result = str.chars()
                .map(a -> a - 48)
                .map(a -> Math.abs(5 - a))
                .sum();

        int result2 = centerValue - result;

        System.out.println(center);
        System.out.println(centerValue);
        System.out.println(result);
        System.out.println(result2);

    }
}

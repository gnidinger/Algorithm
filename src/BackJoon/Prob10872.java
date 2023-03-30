package BackJoon;

import java.util.Scanner;

public class Prob10872 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println(factorial(sc.nextInt()));
    }

    static int factorial(int n) {

        if (n == 0) return 1;

        int head = n;

        int tail = n - 1;

        return head * factorial(tail);
    }
}
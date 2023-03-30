package BackJoon;

import java.util.Scanner;

public class Prob10870 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println(fibonacci(sc.nextInt()));
    }

    static int fibonacci(int n) {

        if (n <= 1) return n;

        return fibonacci(n - 2) + fibonacci(n - 1);
    }
}
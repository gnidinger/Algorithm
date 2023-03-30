package BackJoon;

import java.util.Scanner;

public class Prob11729 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        sb.append((int)Math.pow(2, n) - 1 + "\n"); // 총 횟수

        hanoi(n, 1, 2, 3);

        System.out.println(sb);

    }

    static void hanoi(int n, int start, int mid, int to) {

        if (n == 1) {
            sb.append(start + " " + to + "\n");
            return;
        }

        hanoi(n - 1, start, to, mid);

        sb.append(start + " " + to + "\n");

        hanoi(n - 1, mid, start, to);
    }
}

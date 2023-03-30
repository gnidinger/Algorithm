package BackJoon;

import java.util.Scanner;

public class Prob11050 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int r = sc.nextInt();

        System.out.println(combination(n, r));
    }

    static int combination(int n, int r) {

        if(n == r || r == 0) // base condition
            return 1;
        else
            return combination(n - 1, r) + combination(n - 1, r - 1); // 재귀 함수 호출
    }
}
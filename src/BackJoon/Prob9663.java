package BackJoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Prob9663 {

    private static int n;
    private static List<Integer> list = new ArrayList<>();
    private static int cnt = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            list.add(0);
        }

        nQueen(0);
        System.out.println(cnt);
    }

    static void nQueen(int depth) {

        if (depth == n) {
            cnt++;
            return;
        }

        for (int i = 0; i < n; i++) {
            list.set(depth, i);
            if (isSafe(depth)) {
                nQueen(depth + 1);
            }
        }
    }

    static boolean isSafe(int depth) {

        for (int i = 0; i < depth; i++) {

            if (list.get(depth).equals(list.get(i))) {
                return false;
            }

            else if (Math.abs(depth - i) == Math.abs(list.get(depth) - list.get(i))) {
                return false;
            }
        }
        return true;
    }
}
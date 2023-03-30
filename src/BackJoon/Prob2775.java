package BackJoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Prob2775 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();

        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int k = sc.nextInt();
            int n = sc.nextInt();
            list.add(num(k, n));
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
    public static int num(int k, int n) {

        if (n == 1) return 1;
        if (k == 0) return n;

        return num(k - 1, n) + num(k, n - 1);
    }
}
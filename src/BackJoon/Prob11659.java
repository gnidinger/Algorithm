package BackJoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Prob11659 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        list.add(0);
        list.add(sc.nextInt());

        for (int i = 2; i <= n; i++) {
            list.add(list.get(i - 1) + sc.nextInt());
        }

        for (int i = 0; i < m; i++) {

            int start = sc.nextInt();
            int end = sc.nextInt();

            result.add(list.get(end) - list.get(start - 1));
        }

        for (int ans : result) {
            System.out.println(ans);
        }
    }
}
package BackJoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Prob14425 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int cnt = 0;
        List<String > list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(sc.next());
        }

        for (int i = 0; i < m; i++) {
            if (list.contains(sc.next())) cnt++;
        }

        System.out.println(cnt);

    }
}

package BackJoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Prob10816 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Integer> listN = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            listN.add(sc.nextInt());
        }

        int m = sc.nextInt();
        List<Long> listM = new ArrayList<>();

        for (int i = 0; i < m; i++) {

            int tmp = sc.nextInt();

            listM.add(listN.stream()
                    .filter(a -> a.equals(tmp))
                    .count());
        }

        for (int i = 0; i < m; i++) {
            System.out.print(listM.get(i) + " ");
        }

    }
}

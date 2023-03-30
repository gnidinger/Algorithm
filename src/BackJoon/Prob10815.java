package BackJoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Prob10815 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Integer> listN = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            listN.add(sc.nextInt());
        }
        int m = sc.nextInt();
        List<Integer> listM = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            if (listN.contains(sc.nextInt())) {
                listM.add(1);
            } else {
                listM.add(0);
            }
        }
        for (int i = 0; i < m; i++) {
            System.out.print(listM.get(i) + " ");
        }
    }
}

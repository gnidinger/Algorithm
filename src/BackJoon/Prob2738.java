package BackJoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Prob2738 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();

        for (int i = 0; i < n * m; i++) {
            list1.add(sc.nextInt());
        }
        for (int i = 0; i < n * m; i++) {
            list2.add(sc.nextInt());
        }
        for (int i = 0; i < n * m; i++) {
            list3.add(list1.get(i) + list2.get(i));
        }

        for (int i = 0; i < n; i++) {
            for (int j = i * m; j < i * m + m; j++) {
                System.out.print(list3.get(j) + " ");
            }
            System.out.println();
        }
    }
}
package BackJoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Prob2566 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 81; i++) {
            list.add(sc.nextInt());
        }

        int max = Collections.max(list);
        int idx = list.indexOf(max);

        System.out.println(max);
        System.out.println(idx / 9 + 1 + " " + (idx % 9 + 1));
    }
}
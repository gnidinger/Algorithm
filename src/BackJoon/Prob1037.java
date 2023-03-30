package BackJoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Prob1037 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();



        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        if (n == 1) System.out.println((int) Math.pow(list.get(0), 2));
        else System.out.println(Collections.max(list) * Collections.min(list));


    }
}
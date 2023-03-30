package BackJoon;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Prob10814 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<List<String>> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            List<String> subList = new ArrayList<>();

            subList.add(sc.next());
            subList.add(sc.next());

            list.add(subList);
        }

        list.sort(Comparator.comparingInt(a -> Integer.parseInt(a.get(0))));
        list.sort(Comparator.comparingInt(list::indexOf));

        for (int i = 0; i < n; i++) {
            System.out.println(list.get(i).get(0) + " " + list.get(i).get(1));
        }
    }
}
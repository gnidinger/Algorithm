package BackJoon;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Prob1181 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<String> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(sc.next());
        }

        list.stream()
                .distinct()
                .sorted(String::compareTo)
                .sorted(Comparator.comparing(String::length))
                .forEach(System.out::println);
    }
}
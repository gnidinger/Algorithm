package BackJoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Prob18870 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        List<Integer> sortedList = list.stream()
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        for (int i = 0; i < sortedList.size(); i++) {
            for (int j = 0; j < n; j++) {
                if (list.get(j).equals(sortedList.get(i))) {
                    list.set(j, i);
                }
            }
        }
        System.out.println(list);
    }
}
package BackJoon;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Prob25305Stream {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        int result = list.stream()
                .sorted(Comparator.reverseOrder())
                .mapToInt(Integer::intValue)
                .skip(k - 1)
                .findFirst()
                .getAsInt();

        System.out.println(result);
    }
}
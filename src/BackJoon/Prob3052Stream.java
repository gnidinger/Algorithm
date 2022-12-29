package BackJoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Prob3052Stream {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < 10; i++) {
            list.add(sc.nextInt());
        }

        long result = list.stream()
                .map(a -> a % 42)
                .distinct()
                .count();

        System.out.println(result);
    }
}

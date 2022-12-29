package BackJoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Prob2562Stream {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < 9; i++) {
            list.add(sc.nextInt());
        }

        int max = list.stream()
                .mapToInt(Integer::intValue)
                .max().getAsInt();

        System.out.println(max);
        System.out.println(list.indexOf(max) + 1);
    }
}

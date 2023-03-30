package BackJoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Prob2587Stream_2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            list.add(sc.nextInt());
        }

        IntStream stream = list.stream()
                .sorted()
                .mapToInt(Integer::intValue);

        int ave = (int) stream
                .average()
                .getAsDouble();

        int med = stream
                .skip(2)
                .findFirst()
                .getAsInt();

        System.out.println(ave);
        System.out.println(med);

    }
}
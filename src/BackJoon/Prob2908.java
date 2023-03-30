package BackJoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Prob2908 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<StringBuilder> list = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            list.add(new StringBuilder(sc.next()));
        }

        int result = list.stream()
                .map(a -> a.reverse().toString())
                .mapToInt(Integer::parseInt)
                .max()
                .getAsInt();

        System.out.println(result);
    }
}
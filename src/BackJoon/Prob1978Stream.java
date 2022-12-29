package BackJoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Prob1978Stream {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < n; i++){
            list.add(sc.nextInt());
        }

        int result = (int) list.stream()
                .filter(a ->
                        a > 1 &&
                        IntStream.rangeClosed(2, (int)Math.sqrt(a))
                        .allMatch(b -> a % b != 0))
                .count();

        System.out.println(result);
    }
}
package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Prob9020 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < t; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        List<Integer> primeList = IntStream.rangeClosed(2, Collections.max(list))
                .filter(a ->
                        IntStream.rangeClosed(2, (int) Math.sqrt(a))
                                .allMatch(b -> a % b != 0))
                .boxed()
                .collect(Collectors.toList());

        for (int i = 0; i < t; i++) {

            int finalI = i;

            int max = primeList.stream()
                    .filter(a -> a <= list.get(finalI) / 2)
                    .filter(a -> primeList.contains(list.get(finalI) - a))
                    .mapToInt(Integer::intValue)
                    .max()
                    .getAsInt();

            result.add(List.of(max, list.get(i) - max));
        }

        for (int i = 0; i < t; i++) {
            System.out.println(result.get(i).get(0) + " " + result.get(i).get(1));
        }
    }
}
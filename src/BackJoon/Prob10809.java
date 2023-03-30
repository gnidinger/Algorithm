package BackJoon;

import java.util.*;
import java.util.stream.Collectors;

public class Prob10809 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < 26; i++) {
            result.add(-1);
        }

        List<Integer> ch = sc.nextLine().chars()
                .map(a -> a - 97)
                .boxed()
                .collect(Collectors.toList());

        for (int i = 0; i < ch.size(); i++) {
            if (result.get(ch.get(i)) == -1) result.set(ch.get(i), i);
            else continue;
        }

        for (int i = 0; i < 26; i++) {
            System.out.print(result.get(i) + " ");
        }
    }
}
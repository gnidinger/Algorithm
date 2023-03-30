package BackJoon;

import java.util.*;

public class Prob2675 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<String> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            int a = sc.nextInt();

            list.add(Arrays.stream(sc.nextLine().trim().split(""))
                    .map(b -> b.repeat(a))
                    .reduce((x, y) -> x + y)
                    .get());
        }

        for (int i = 0; i < n; i++) {
            System.out.println(list.get(i));
        }
    }
}
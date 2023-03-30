package BackJoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Prob4153 {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<List<Integer>> list = new ArrayList<>();
        List<String> result = new ArrayList<>();

        while (true) {
            List<Integer> subList = new ArrayList<>();

            subList.add(sc.nextInt());
            subList.add(sc.nextInt());
            subList.add(sc.nextInt());

            if (subList.equals(List.of(0, 0, 0)))
                break;

            list.add(subList);
        }

        int l = list.size();

        list.forEach(Collections::sort);

        for (List<Integer> integers : list) {
            int a = integers.get(0);
            int b = integers.get(1);
            int c = integers.get(2);

            boolean b1 = Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2) ? result.add("right") : result.add("wrong");
        }

        for (int i = 0; i < l; i++) {
            System.out.println(result.get(i));
        }
    }
}
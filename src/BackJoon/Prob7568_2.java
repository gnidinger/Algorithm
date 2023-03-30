package BackJoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Prob7568_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<List<Integer>> list = new ArrayList<>();

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            List<Integer> subList = new ArrayList<>();
            subList.add(sc.nextInt());
            subList.add(sc.nextInt());
            list.add(subList);
        }

        for (int i = 0; i < n; i++) {
            int rank = 1;

            for (int j = 0; j < n; j++) {

                if (i == j) continue;
                if (list.get(i).get(0) < list.get(j).get(0) && list.get(i).get(1) < list.get(j).get(1)){
                    rank++;
                }
            }
            System.out.print(rank + " ");
        }
    }
}
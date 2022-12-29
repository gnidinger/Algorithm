package BackJoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Prob1546Stream {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        int max = list.stream()
                .mapToInt(a -> a)
                .max().getAsInt();

        double result = list.stream()
                .mapToDouble(a -> a)
                .map(a -> a * 100/max)
                .average().getAsDouble();

        System.out.println(result);
    }
}

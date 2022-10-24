import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Prob4344Stream {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int total = sc.nextInt();

        for (int i = 0; i < total; i++) {
            double n = sc.nextDouble();
            List<Integer> list = new ArrayList<>();

            for (int j = 0; j < n; j ++) {
                list.add(sc.nextInt());
            }

            double ave = list.stream()
                    .mapToDouble(a -> a)
                    .average().getAsDouble();

            long top = list.stream()
                    .filter(a -> a > ave)
                    .count();

            System.out.println(String.format("%.3f", top * 100 / n)+"%");
        }
    }
}

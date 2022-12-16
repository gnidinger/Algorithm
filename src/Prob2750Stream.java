import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Prob2750Stream {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        list.stream()
                .sorted()
                .forEach(System.out::println);
    }
}
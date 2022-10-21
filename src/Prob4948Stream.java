import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Prob4948Stream {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> list = new ArrayList<>();

        while(true) {
            list.add(sc.nextInt());
            if(list.contains(0)) break;
        }

        list.remove(list.size() - 1);

        list.stream()
                .map(a -> IntStream.rangeClosed(a + 1, a * 2)
                        .filter(b -> IntStream.rangeClosed(2, (int)Math.sqrt(b)).allMatch(c -> b % c != 0))
                        .count())
                .forEach(System.out::println);
    }
}
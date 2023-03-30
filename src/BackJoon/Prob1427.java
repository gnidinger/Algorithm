package BackJoon;

import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Prob1427 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println(sc.next().chars()
                .map(a -> a - 48)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .map(String::valueOf)
                .collect(Collectors.joining()));

    }
}
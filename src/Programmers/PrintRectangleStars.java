package Programmers;

import java.util.Scanner;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

class PrintRectangleStars {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        IntStream.rangeClosed(1, b)
                .mapToObj(x ->
                        IntStream.rangeClosed(1, a)
                                .mapToObj(y -> "*")
                                .collect(Collectors.joining())
                )
                .forEach(System.out::println);
    }
}
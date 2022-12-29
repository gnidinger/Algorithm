package BackJoon;

import java.util.Scanner;

public class Prob11720Stream {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int result = sc.next().chars()
                .map(a -> a - 48)
                .sum();

        System.out.println(result);
    }
}


//    Scanner sc = new Scanner(System.in);
//
//    int n = sc.nextInt();
//    BigInteger x = sc.nextBigInteger();
//
//    List<Integer> list = new ArrayList<>();
//
//        for(int i = 0; i < n; i++) {
//        list.add((x.remainder(BigInteger.TEN)).intValue());
//        x = x.divide(BigInteger.TEN);
//        }
//
//        int result = list.stream()
//        .mapToInt(a -> a)
//        .sum();
//
//        System.out.println(result);
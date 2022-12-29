package BackJoon;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Prob1193Stream {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();

        int n = IntStream.rangeClosed(0,4472)
                .filter(a -> (a * a + a) / 2 < x)
                .map(a -> a + 1)
                .max()
                .getAsInt();

        int num = x - (n * n - n)/2;
        int den = n - num + 1;

        if(n % 2 == 0) System.out.println(num+"/"+den);
        else System.out.println(den+"/"+num);
    }
}
package BackJoon;

import java.util.Scanner;

public class Prob3053 {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double r = sc.nextDouble();

        double a1 = Math.round(Math.pow(r, 2) * Math.PI * 1000000) / 1000000.0;
        double a2 = Math.pow(r, 2) * 2;

        System.out.println(String.format("%.6f", a1));
        System.out.println(String.format("%.6f", a2));
    }
}
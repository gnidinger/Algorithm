package BackJoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Prob1085 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();

        list.add(sc.nextInt());
        list.add(sc.nextInt());
        list.add(sc.nextInt() - list.get(0));
        list.add(sc.nextInt() - list.get(1));

        System.out.println(Collections.min(list));
    }
}
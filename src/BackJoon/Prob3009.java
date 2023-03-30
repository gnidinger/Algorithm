package BackJoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Prob3009 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> listX = new ArrayList<>();
        List<Integer> listY = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            listX.add(sc.nextInt());
            listY.add(sc.nextInt());
        }

        Collections.sort(listX);
        Collections.sort(listY);

        System.out.print(!listX.get(0).equals(listX.get(1)) ? listX.get(0) + " " : listX.get(2) + " ");
        System.out.print(!listY.get(0).equals(listY.get(1)) ? listY.get(0) : listY.get(2));
    }
}
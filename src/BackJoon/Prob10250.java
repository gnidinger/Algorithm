package BackJoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Prob10250 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int total = sc.nextInt();

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < total; i++) {
            int h = sc.nextInt(); // 층 수
            int w = sc.nextInt(); // 방 수
            int n = sc.nextInt(); // 몇 번째 손님인지

            int floor = 0; // 배정될 층
            int num = 0; // 배정될 방

            if (n % h == 0) {
                floor = h * 100;
            } else {
                floor = (n % h) * 100;
            }

            num = (int) Math.ceil(n / (h * 1.0)); // 배정될 호수

            list.add(floor + num);
        }

        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}
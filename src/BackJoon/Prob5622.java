package BackJoon;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Prob5622 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Integer> list = sc.next().chars()
                .map(a -> (a - 65)) // A = 0 으로 맞추기
                .boxed()
                .collect(Collectors.toList());

        int result = 0;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) < 15) {
                result = result + list.get(i) / 3 + 3;
            }
            if (15 <= list.get(i) && list.get(i) <= 18) {
                result = result + 8;
            }
            if (19 <= list.get(i) && list.get(i) <= 21) {
                result = result + 9;
            }
            if (22 <= list.get(i) && list.get(i) <= 25) {
                result = result + 10;
            }
        }
        System.out.println(result);
    }
}
package BackJoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Prob4344Stream {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int total = sc.nextInt(); // 테스트 케이스 개수

        for (int i = 0; i < total; i++) {

            double n = sc.nextDouble();
            List<Integer> list = new ArrayList<>();

            for (int j = 0; j < n; j ++) {
                list.add(sc.nextInt());
            }

            double ave = list.stream() // 평균
                    .mapToDouble(a -> a)
                    .average().getAsDouble();

            long top = list.stream() // 평균 넘는 학생 필터링 해서 카운트
                    .filter(a -> a > ave)
                    .count();

            System.out.println(String.format("%.3f", top * 100 / n)+"%"); // 비율 소수점 셋째 자리까지
        }
    }
}

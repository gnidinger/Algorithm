package BackJoon;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Prob2563 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<Integer> areaList = IntStream.of(new int[10000]) // 일차원 리스트 생성
                .boxed()
                .collect(Collectors.toList());

        for (int i = 0; i < n; i++) { // n 개의 색종이

            int x = sc.nextInt(); // x 좌표랑
            int y = sc.nextInt(); // y 좌표를 받아
            int z = y * 100 + x; // 일차원 리스트의 인덱스 z로 매핑

            for (int j = z; j < z + 1000; j = j + 100) {
                for (int k = 0; k < 10; k++) {
                    areaList.set(j + k, 1);
                }
            }
        }

        long area = areaList.stream()
                .filter(a -> a == 1) // 리스트 안의 1의 개수 세서
                .count();

        System.out.println(area); // 출력
    }
}
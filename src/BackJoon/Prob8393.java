package BackJoon;// n이 주어졌을 때, 1부터 n까지 합을 구하는 프로그램을 작성
// 첫째 줄에 n (1 ≤ n ≤ 10,000)이 주어짐
// 1부터 n까지의 합 출력

import java.util.Scanner;

public class Prob8393 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int result = 0;

        for(int i = 1; i <= n; i++) {
            result += i;
        }

        System.out.println(result);
    }
}

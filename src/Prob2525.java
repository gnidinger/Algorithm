// 첫째 줄에는 현재 시각이 나온다. 시 h (0 ≤ h ≤ 23) 와 분 m (0 ≤ m ≤ 59)이 정수로 빈칸을 사이에 두고 순서대로 주어진다.
// 두 번째 줄에는 요리하는 데 필요한 시간 c (0 ≤ c ≤ 1,000)가 분 단위로 주어진다.

import java.util.Scanner;

public class Prob2525 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int h = sc.nextInt();
        int m = sc.nextInt();
        int c = sc.nextInt(); // 소요시간(분)

        if (m + c < 60) { // 현재 분 + 소요시간이 60을 넘지 않을 경우
            m += c;
        } else if (m + c >= 60) { // 현재 분 + 소요시간이 60을 넘을 경우
            h += (m + c) / 60; // 시간은 60으로 나눈 몫만큼 더해주기
            m = (m + c) % 60; // 분은 60으로 나눈 나머지를 더해주기
            if (h >= 24) { // 시간이 24시간을 넘는 경우
                h = h % 24; // 24로 나눈 나머지를 시간에 대입한다
            }
        }
        System.out.printf("%d %d", h, m);
    }
}

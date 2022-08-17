// "45분 일찍 알람 설정하기"
// 원래 설정되어 있는 알람을 45분 앞서는 시간으로 바꾸는 것
// 첫째 줄에 두 정수 H와 M이 주어진다. (0 ≤ H ≤ 23, 0 ≤ M ≤ 59) 그리고 이것은 현재 설정해 놓은 알람 시간 H시 M분을 의미한다.
// 입력 시간은 24시간 표현을 사용한다. 시간을 나타낼 때, 불필요한 0은 사용하지 않는다.

import java.util.Scanner;

public class Prob2884 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int h = sc.nextInt();
        int m = sc.nextInt();

        if(m >= 45) {
            h = h;
            m = m - 45;
        } else if (m < 45) {
            if(h == 0) {
                h = 23;
                m += 15;
            } else {
                h = h - 1;
                m += 15;
            }
        }
        System.out.printf("%d %d", h, m);
//         System.out.print(h);
//        System.out.print(" ");
//        System.out.print(m);
    }
}

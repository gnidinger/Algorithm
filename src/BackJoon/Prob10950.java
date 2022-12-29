package BackJoon;// 두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성
// 첫째 줄에 테스트 케이스의 개수 T가 주어진다.
// 각 테스트 케이스는 한 줄로 이루어져 있으며, 각 줄에 A와 B가 주어진다. (0 < A, B < 10)
// 각 테스트 케이스마다 A+B를 출력한다.


import java.util.Scanner;

public class Prob10950 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] result = new int[n];
        for(int i = 0; i < n; i ++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            result[i] = a + b;
        }

        for(int i : result){
            System.out.println(i);
        }
    }
}

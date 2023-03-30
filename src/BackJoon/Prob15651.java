package BackJoon;

import java.util.Scanner;

public class Prob15651 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n]; // 순열을 만들 배열

        for (int i = 0; i < n; i++){
            arr[i] = i + 1;
        }

        int[] output = new int[n]; // 순열을 저장하기 위한 배열

        per(arr, output, 0, n, m);
    }

    static int cnt = 0;
    //순서를 지키면서 n 개중에서 r 개를 뽑는 경우
    static void per(int[] arr, int[] output, int depth, int n, int r) {
        if (depth == r) { // base condition
            cnt++;
            print(output, r); //순열 출력을 위한 print 함수
            return;
        }

        for(int i = 0; i < n; i++) {
            output[depth] = arr[i];
            per(arr, output, depth + 1, n, r); // 재귀함수 호출
        }
    }

    static void print(int[] arr, int r) { // 배열 출력을 위한 메서드
        for(int i = 0; i < r; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
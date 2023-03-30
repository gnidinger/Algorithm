package BackJoon;

import java.util.Scanner;

public class Prob15652 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n]; // 조합을 만들 배열

        for (int i = 0; i < n; i++){
            arr[i] = i + 1;
        }

        comb(arr, new int[m], 0, 0, n, m); // n개중 r개를 중복 조합으로 뽑는 경우 출력

    }

    static void comb(int[] arr, int[] output, int start, int depth, int n, int r) {

        if(depth == r) {
            for(int i = 0; i < output.length; i++) {
                System.out.print(output[i] + " ");
            }
            System.out.println();
            return;
        }
        for(int i = start; i < n; i++)  {
            // 재귀함수 호출
            output[depth] = arr[i];
            comb(arr, output, i, depth + 1 , n, r); // i + 1이 아닌 i 대입, r - 1이 아닌 r 대입
        }
    }
}
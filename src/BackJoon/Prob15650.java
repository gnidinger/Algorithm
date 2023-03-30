package BackJoon;

import java.util.Scanner;

public class Prob15650 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n]; // 조합을 만들 배열
        boolean[] isVisited = new boolean[n]; // 선택했는지 체크하는 배열

        for (int i = 0; i < n; i++){
            arr[i] = i + 1;
        }

        comb(arr, isVisited, 0, n, m); // nCr 경우의 수 출력
    }

    static void comb(int[] arr, boolean[] isVisited, int depth, int n, int r) {
        if(r == 0) { // base condition
            print(arr, isVisited);
            return;
        }
        if(depth == n) {
            return;
        } else {
            isVisited[depth] = true;
            comb(arr, isVisited, depth + 1, n, r - 1); // 재귀함수 호출

            isVisited[depth] = false;
            comb(arr, isVisited, depth + 1, n, r);
        }
    }

    static void print(int[] arr, boolean[] isVisited) { // 배열 출력을 위한 메서드
        for(int i = 0; i < arr.length; i++) {
            if(isVisited[i])
                System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
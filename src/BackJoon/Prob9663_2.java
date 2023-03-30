package BackJoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Prob9663_2 {

    static int cnt = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] arr = new int[n][n];

        nQueen(arr, n, 0, 0,0);

        System.out.println(cnt);

        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }

    }

    static void nQueen(int[][] arr, int n, int depth, int row, int column) {

        if (depth == n) {
            cnt++;
            return;
        }

        for (int i = 0; i < n; i++) { // 선택한 공간 다 칠함

            arr[row][i] = 1;
            arr[i][column] = 1;

            for (int j = 0; j < n; j++) {
                if (Math.abs(i - 2) == Math.abs(j - 1)) {
                    arr[i][j] = 1;
                }
            }
            depth++;
        }

        findCoor(arr);
    }

    static boolean findCoor(int[][] arr) {

        return true;
    }
}
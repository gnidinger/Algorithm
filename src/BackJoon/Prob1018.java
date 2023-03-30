package BackJoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Prob1018 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int maxRow = n - 7;
        int m = sc.nextInt();
        int maxCol = m - 7;

        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) { // +1, -1로 매핑
            arr[i] = sc.next().chars()
                    .map(a -> (a - 76)/10)
                    .toArray();
        }

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < maxRow; i++) {
            for (int j = 0; j < maxCol; j++) {

                int z = arr[i][j];
                int cnt = 0;

                for (int a = i; a < i + 8; a++) {
                    for (int b = j; b < j + 8; b++) {

                        if (arr[a][b] != z) {
                            cnt++;
                        }
                        z = -z;
                    }
                    z = -z;
                }
               list.add(Math.min(cnt, 64 - cnt));
            }
        }
        System.out.println(list.stream().mapToInt(Integer::intValue).min().getAsInt());
    }
}
package BackJoon;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class
Prob1010 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        List<Integer> list = new ArrayList<>();
        int t = Integer.parseInt(br.readLine());


        for (int i = 0; i < t; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            list.add(combination(n, r));
        }

        for (int i = 0; i < t; i++) {
            bw.write(list.get(i) + "\n");
        }

        bw.flush();
        bw.close();
    }

    static int combination(int n, int r) {

        int[][] memo = new int[n + 1][r + 1];

        memo[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= r; j++) {

                if (i == j || j == 0) {
                    memo[i][j] = 1;
                } else {
                    memo[i][j] = memo[i - 1][j] + memo[i - 1][j - 1];
                }
            }
        }
        return memo[n][r];
    }
}
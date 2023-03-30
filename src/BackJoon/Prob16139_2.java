package BackJoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Prob16139_2 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        int q = Integer.parseInt(br.readLine());

        int[][] arr = new int[26][str.length()];
        int[] result = new int[q];

        for (int i = 0; i < str.length(); i++) { // 문자열 처음 인덱스부터 순회
            int alpha = str.charAt(i) - 97; // 알파벳 -> 아스키코드 매핑

            arr[alpha][i] += 1;
            int[] subarr = Arrays.copyOfRange(arr[alpha], i, str.length() + 1);
            Arrays.fill(subarr, arr[alpha][i]);
            System.arraycopy(subarr, 0, arr[alpha], i, subarr.length - 1);
        }

        for (int i = 0; i < q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = st.nextToken().charAt(0) - 97;
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            if (l == 0) bw.append(arr[a][r] + "\n");
            else bw.append(arr[a][r] - arr[a][l - 1] + "\n");
        }

        bw.flush();
        bw.close();
    }
}
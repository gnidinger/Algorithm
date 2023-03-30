package BackJoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Prob16139_3 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int q = Integer.parseInt(br.readLine());

        int[][] arr = new int[26][str.length() + 1];

        arr[str.charAt(0) - 'a'][1] = 1;

        for (int i = 2; i <= str.length(); i++) { // 문자열 처음 인덱스부터 순회
            int alpha = str.charAt(i - 1) - 'a'; // 알파벳 -> 아스키코드 매핑

            for (int j = 0; j < 26; j++) {
                int cnt = arr[j][i - 1];
                arr[j][i] = j == alpha ? cnt + 1 : cnt;
            }
        }

        for (int i = 0; i < q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = st.nextToken().charAt(0) - 97;
            int l = Integer.parseInt(st.nextToken()) + 1;
            int r = Integer.parseInt(st.nextToken()) + 1;

            bw.append(arr[a][r] - arr[a][l - 1] + "\n");
        }

        bw.flush();
        bw.close();
    }
}
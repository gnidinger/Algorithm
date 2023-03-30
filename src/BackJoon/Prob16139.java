package BackJoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Prob16139 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int q = Integer.parseInt(br.readLine());

        int[][] arr = new int[26][str.length()];
        int[] result = new int[q];

        for (int i = 1; i < str.length(); i++) { // 문자열 처음 인덱스부터 순회
            int alpha = str.charAt(i) - 97; // 알파벳 -> 아스키코드 매핑
            int cnt = 0; // 몇 번 나왔는지 누적합
            arr[str.charAt(0) - 97][0] = 1;

            for (int j = 0; j <= i; j++) { // j번째까지 알파벳이 몇 번 등장하는지
                cnt = Arrays.stream(arr[alpha]).max().getAsInt();
            }
            arr[alpha][i] = cnt + 1;
            int[] subarr = Arrays.copyOfRange(arr[alpha], i, str.length() + 1);
            Arrays.fill(subarr, cnt + 1);
            System.arraycopy(subarr, 0, arr[alpha], i, subarr.length - 1);



//            if (cnt + 1 >= 2) {
//                for (int j = Arrays.asList(arr[alpha]).indexOf(cnt) + 1; j < i; j++) {
//                    arr[alpha][j] = cnt;
//                }
//            }
        }

//        for (int i = 0; i < 26; i++) {
//            System.out.println(Arrays.toString(arr[i]));
//        }

        for (int i = 0; i < q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = st.nextToken().charAt(0) - 97;
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            if (l == 0) result[i] = arr[a][r];
            else result[i] = arr[a][r] - arr[a][l - 1];
        }

//        for (int i = 0; i < q; i++) {
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            int a = st.nextToken().charAt(0) - 97;
//            int l = Integer.parseInt(st.nextToken());
//            int r = Integer.parseInt(st.nextToken());
//
//            if (l == 0) result[i] = Arrays.stream(Arrays.copyOf(arr[a], r + 1)).max().getAsInt();
//            else result[i] = Arrays.stream(Arrays.copyOf(arr[a], r + 1)).max().getAsInt()
//                    - Arrays.stream(Arrays.copyOf(arr[a], l)).max().getAsInt();
//        }
//
        Arrays.stream(result).forEach(System.out::println);
    }
}
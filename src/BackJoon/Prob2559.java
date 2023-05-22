package BackJoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Prob2559 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        int[] result = new int[n - k + 1];

        StringTokenizer stn = new StringTokenizer(br.readLine());

        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(stn.nextToken());
            result[0] += arr[i];
        }

        for (int i = k; i < n; i++) {
            arr[i] = Integer.parseInt(stn.nextToken());
            result[i - k + 1] = result[i - k] + arr[i] - arr[i - k];
        }

        System.out.println(Arrays.stream(result).max().getAsInt());
    }
}
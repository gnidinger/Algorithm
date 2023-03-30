package BackJoon;

import java.io.*;
import java.util.Arrays;

public class Prob10989 {

    private static int[] result;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] target = new int[n];

        for (int i = 0; i < n; i++) {
            target[i] = Integer.parseInt(br.readLine());
        }

        countingSortImpl(target);

        for (int i = 0; i < n; i++) {
            bw.write(result[i] + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static void countingSortImpl(int[] target) {

        int[] counting = new int[Arrays.stream(target).max().getAsInt() + 1];
        result = new int[target.length];

        for (int i = 0; i < target.length; i++) { // Counting
            counting[target[i]]++;
        }

        for (int i = 1; i < counting.length; i++) { // 누적 합
            counting[i] += counting[i - 1];
        }

        for (int i = target.length - 1; i >= 0; i--) { // 정렬
            counting[target[i]]--; // 해당 인덱스 값을 하나 줄여주고
            result[counting[target[i]]] = target[i]; // 줄여진 수를 인덱스 삼아 result에 값 채우기
        }
    }
}
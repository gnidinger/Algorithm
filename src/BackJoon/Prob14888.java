package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Prob14888 {

    private static List<Integer> list = new ArrayList<>(); // 기본 리스트
    private static int[] result = new int[2];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        StringBuilder str = new StringBuilder();

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            int temp = Integer.parseInt(st1.nextToken());

                for (int j = 0; j < temp; j++) {
                    char tail = (char) (i + 66);
                    str.append(tail);

            }
        }

        String[] arr = str.toString().split("");

        operation(arr);

        System.out.println(result[0]);
        System.out.println(result[1]);

    }

    private static void operation(String[] arr) {

        int n = arr.length; // 배열의 길이
        String[] output = new String[n]; // 순열을 저장하기 위한 배열
        boolean[] isVisited = new boolean[n]; // 선택했는지 체크하는 배열

        per(arr, output, isVisited, 0, n, n); // n개를 뽑는 경우(r = n)
    }

    static void per(String[] arr, String[] output, boolean[] isVisited, int depth, int n, int r) {

        if (depth == r) { // base condition
            oper(list, output);
            return;
        }

        for(int i = 0; i < n; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                output[depth] = arr[i];
                per(arr, output, isVisited, depth + 1, n, r); // 재귀함수 호출
                isVisited[i] = false;
            }
        }
    }

    private static void oper(List<Integer> list, String[] arr) {

        int value = list.get(0);

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals("B")) value = value + list.get(i + 1);
            if (arr[i].equals("C")) value = value - list.get(i + 1);
            if (arr[i].equals("D")) value = value * list.get(i + 1);
            if (arr[i].equals("E")) value = value / list.get(i + 1);
        }

        if (result[0] == 0 && result[1] == 0){
            result[0] = value;
            result[1] = value;
        } else if (value > result[0]) {
            result[0] = value;
        } else if (value < result[1]) {
            result[1] = value;
        }
    }
}
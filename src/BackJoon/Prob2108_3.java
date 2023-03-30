package BackJoon;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Prob2108_3 {

    private static int[] result;
    private static int mode;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] target = new int[n];

        for (int i = 0; i < n; i++) {
            target[i] = Integer.parseInt(br.readLine()) + 4000;
        }

        countingSortImpl(target);

        IntSummaryStatistics stat = Arrays.stream(result)
                .map(a -> a - 4000)
                .boxed()
                .collect(Collectors.summarizingInt(Integer::intValue));

        int median = result[n / 2] - 4000;

        bw.write(Math.round(stat.getAverage()) + "\n"); // 산술 평균
        bw.write(median + "\n"); // 중앙값
        bw.write(mode + "\n"); // 최빈값
        bw.write(stat.getMax() - stat.getMin() + "\n"); // 범위

        bw.flush();
        bw.close();
    }

    public static void countingSortImpl(int[] target) {

        int[] counting = new int[Arrays.stream(target).max().getAsInt() + 1];
        result = new int[target.length];

        for (int i = 0; i < target.length; i++) { // Counting
            counting[target[i]]++;
        }

        List<Integer> sortedList = Arrays.stream(counting)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        if (sortedList.get(0).equals(sortedList.get(1))) {

            mode = Arrays.stream(target)
                    .filter(a -> counting[a] == sortedList.get(0))
                    .distinct()
                    .boxed()
                    .sorted()
                    .skip(1)
                    .findFirst()
                    .get() - 4000;

        } else {
            mode = IntStream.of(counting).boxed().collect(Collectors.toList()).indexOf(sortedList.get(0)) - 4000;
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
package BackJoon;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Prob2108_2 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();
        int[] cntArr = new int[8001];


        for (int i = 0; i < n; i++) {

            int a = Integer.parseInt(br.readLine()); // 절대값이 4000이라고 했으니 음수 보정

            if (list.contains(a)) {
                cntArr[a + 4000]++;
                list.add(a);
            } else {
                cntArr[a + 4000] = 1;
                list.add(a);
            }
        }

        int mode = 0;

        List<Integer> sortedList = Arrays.stream(cntArr)
                .distinct()
                .boxed()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        if (sortedList.get(0) == sortedList.get(1)) {

            mode = IntStream.rangeClosed(0, 8000)
                    .filter(a -> Objects.equals(cntArr[a], sortedList.get(1)))
                    .map(a -> a - 4000)
                    .distinct()
                    .skip(1)
                    .findFirst()
                    .getAsInt();

        } else {
            mode = cntArr[sortedList.get(0)] - 4000;
        }

        int median = list.stream().sorted().collect(Collectors.toList()).get(n / 2);

        IntSummaryStatistics stat = list.stream()
                .collect(Collectors.summarizingInt(a -> a));

        bw.write(Math.round(stat.getAverage()) + "\n");
        bw.write(median + "\n");
        bw.write(mode + "\n");
        bw.write(stat.getMax() - stat.getMin() + "\n");

        bw.flush();
        bw.close();
    }
}
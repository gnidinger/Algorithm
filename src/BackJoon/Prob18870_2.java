package BackJoon;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Prob18870_2 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        List<Integer> sortedList = list.stream()
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        int num = 0;

        for (int i : sortedList) {
            map.put(i,num);
            num++;
        }

        for (int i : list) {
            bw.write(map.get(i) + " ");
        }

        bw.flush();
        bw.close();
    }
}
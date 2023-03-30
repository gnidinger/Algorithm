package BackJoon;

import java.io.*;
import java.util.*;

public class Prob10814_2 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        List<List<String>> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            List<String> subList = new ArrayList<>();

            subList.add(st.nextToken());
            subList.add(st.nextToken());

            list.add(subList);
        }

        list.sort(Comparator.comparingInt(a -> Integer.parseInt(a.get(0))));

        for (int i = 0; i < n; i++) {
            bw.write(list.get(i).get(0) + " " + list.get(i).get(1) + "\n");
        }

        bw.flush();
        bw.close();
    }
}
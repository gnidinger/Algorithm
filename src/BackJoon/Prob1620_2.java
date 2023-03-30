package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Prob1620_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, String> map = new HashMap<>();
        Map<String, String> reverseMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            map.put(String.valueOf(i + 1), str);
            reverseMap.put(str, String.valueOf(i + 1));
        }

        for (int i = 0; i < m; i++) {
            String tmp = br.readLine();
            if (map.containsKey(tmp)) sb.append(map.get(tmp)).append('\n');
            else sb.append(reverseMap.get(tmp)).append('\n');
        }
        System.out.println(sb);
    }
}

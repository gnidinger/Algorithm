package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Prob10816_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            String a = st.nextToken();
            if (map.containsKey(a)) map.put(a, map.get(a) + 1);
            else map.put(a, 1);
        }

        int m = Integer.parseInt(br.readLine());

        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            String b = st2.nextToken();
            if (map.containsKey(b)) sb.append(map.get(b)).append(" ");
            else sb.append(0).append(" ");
        }

        System.out.println(sb);
    }
}

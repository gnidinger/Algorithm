package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Prob1764_2 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Set<String> setN = new TreeSet<>();
        Set<String> setM = new HashSet<>();

        for (int i = 0; i < n; i++) {
            setN.add(br.readLine());
        }

        for (int i = 0; i < m; i++) {
            setM.add(br.readLine());
        }

        setN.retainAll(setM);

        System.out.println(setN.size());

        for (String result : setN) {
            System.out.println(result);
        }
    }
}

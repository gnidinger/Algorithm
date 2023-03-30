package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Prob1269_2 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Set<Integer> setN = new HashSet<>();
        Set<Integer> setM = new HashSet<>();

        StringTokenizer stN = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            setN.add(Integer.parseInt(stN.nextToken()));
        }

        StringTokenizer stM = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            setM.add(Integer.parseInt(stM.nextToken()));
        }

        Set<Integer> union = new HashSet<>(setN);

        // 합집합
        union.addAll(setM);

        Set<Integer> inter = new HashSet<>(setN);

        // 교집합
        inter.retainAll(setM);

        // 대칭 차집합
        union.removeAll(inter);

        System.out.println(union.size());
    }
}

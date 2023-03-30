package BackJoon;

import java.util.*;

public class Prob1269 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        Set<Integer> setN = new HashSet<>();
        Set<Integer> setM = new HashSet<>();

        for (int i = 0; i < n; i++) {
            setN.add(sc.nextInt());
        }

        for (int i = 0; i < m; i++) {
            setM.add(sc.nextInt());
        }

        Set<Integer> union = new HashSet<>(setN);
        union.addAll(setM);

        Set<Integer> inter = new HashSet<>(setN);
        inter.retainAll(setM);

        union.removeAll(inter);

        System.out.println(union.size());
    }
}

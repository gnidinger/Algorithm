package BackJoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Prob1764 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        List<String> listN = new ArrayList<>();
        List<String> listM = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            listN.add(sc.next());
        }

        for (int i = 0; i < m; i++) {

            String tmp = sc.next();

            String result = listN.stream()
                    .filter(a -> a.equals(tmp))
                    .findFirst()
                    .orElse(null);

            if (result != null) listM.add(result);
        }

        Collections.sort(listM);

        System.out.println(listM.size());

        for (int i = 0; i < listM.size(); i++) {
            System.out.println(listM.get(i));
        }

    }
}

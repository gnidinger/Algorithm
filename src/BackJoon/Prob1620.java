package BackJoon;

import java.util.*;

public class Prob1620 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        Map<String, String> map = new HashMap<>();
        List<String> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            map.put(String.valueOf(i + 1), sc.next());
        }

        for (int i = 0; i < m; i++) {
            String tmp = sc.next();
            if (map.containsKey(tmp)) list.add(map.get(tmp));
            if (map.containsValue(tmp)) {
                list.add(map.entrySet().stream()
                        .filter(a -> tmp.equals(a.getValue()))
                        .findFirst()
                        .map(Map.Entry::getKey)
                        .get());
            }
        }
        for (int i = 0; i < m; i++) {
            System.out.println(list.get(i));
        }
    }
}

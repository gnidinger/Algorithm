package BackJoon;

import java.util.*;
import java.util.stream.Collectors;

public class Prob7568 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> rankingList = new ArrayList<>();

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            rankingList.add(1);
            List<Integer> subList = new ArrayList<>();
            subList.add(sc.nextInt());
            subList.add(sc.nextInt());
            list.add(subList);
        }

        List<List<Integer>> sortedList = list.stream()
                .sorted(Comparator.comparingInt(a -> a.get(0)))
                .sorted(Comparator.comparingInt(a -> a.get(1)))
                .collect(Collectors.toList());
        Collections.reverse(sortedList);

        for (int i = 0; i < n - 1; i++) {
            if (sortedList.get(i).get(0) > sortedList.get(i + 1).get(0)) { // 몸무게가 무거운 경우
                if (sortedList.get(i).get(1) > sortedList.get(i + 1).get(1)) { // 키도 큰 경우
                    rankingList.set(list.indexOf(sortedList.get(i)), rankingList.get(list.indexOf(sortedList.get(i))));
                    rankingList.set(list.indexOf(sortedList.get(i + 1)), i + 2);
                }
            } else { // 몸무게가 가벼운 경우
                rankingList.set(list.indexOf(sortedList.get(i)), rankingList.get(list.indexOf(sortedList.get(i))));
                rankingList.set(list.indexOf(sortedList.get(i + 1)), rankingList.get(list.indexOf(sortedList.get(i))));
            }
        }

        System.out.println(sortedList);
        System.out.println(rankingList);
    }
}
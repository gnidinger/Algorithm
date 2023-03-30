package BackJoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Prob1316 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        List<Boolean> booleanList = new ArrayList<>();

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            list.add(sc.next());
            booleanList.add(false);
        }

        for (int j = 0; j < n; j++) {

            for (int i = 0; i < list.get(j).length(); i++) {

                String str = list.get(j); // j 번째 문자열
                List<Integer> ascii = str.chars() // 해당 문자열 알파벳 아스키코드로 나눠서 저장. 소문자만 주어지므로 가공 필요 없음
                        .boxed()
                        .collect(Collectors.toList());

                int firstIdx = str.indexOf(str.charAt(i)); // 해당 문자열에서 i번째 알파벳의 첫 인덱스
                int lastIdx = str.lastIndexOf(str.charAt(i)); // 해당 문자열에서 i번째 알파벳의 마지막 인덱스

                long result = ascii.stream() // 연속 여부와 상관 없는 해당 알파벳의 개수
                        .filter(a -> a.equals(ascii.get(firstIdx)))
                        .count();

                if (lastIdx == firstIdx) booleanList.set(j, true); // 해당 문자열의 길이가 1이면 true
                else { // 문자열의 길이가 2 이상일 경우
                    if (result == lastIdx - firstIdx + 1) { // result와 문자열 길이가 같으면 true
                        booleanList.set(j, true);
                    } else {
                        booleanList.set(j, false);
                        break; // 아니면 false, 하나라도 false면 바로 순회 종료
                    }
                }
            }
        }
        System.out.println(booleanList.stream().filter(a -> a.equals(true)).count());
    }
}
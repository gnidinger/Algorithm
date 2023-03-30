package BackJoon;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Prob1157 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < 26; i++) { // 알파벳 개수만큼 0으로 채운 result 생성
            result.add(0);
        }

        List<Integer> ch = sc.nextLine().toUpperCase().chars() // 문자열 대문자로 바꾼 뒤 아스키코드로 전환, 65를 빼서 A = 0 으로 맞춤
                .map(a -> a - 65)
                .boxed()
                .collect(Collectors.toList());

        for (int i = 0; i < ch.size(); i++) { // 문자열 길이만큼 반복하면서

            int alphabet = ch.get(i); // 해당 문자열의 i번째 아스키코드를 받아 result 의 인덱스로 사용

            result.set(alphabet, result.get(alphabet) + 1); // result 에서 해당 알파벳 인덱스의 값을 1 증가
        }

        List<Integer> sortedResult = result.stream() // 결과를 내림차순으로 정렬
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        if (sortedResult.get(0).equals(sortedResult.get(1))) System.out.println("?"); // 같은 빈도의 알파벳이 두 개 이상이면 "?" 출력
        else System.out.println((char) (result.indexOf(sortedResult.get(0)) + 65)); // 하나뿐이면 해당 알파벳을 다시 char로 돌려 출력
    }
}
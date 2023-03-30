package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Prob25501 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < t; i++) {
            list.add(isPalindrome(br.readLine()));
        }
        for (int i = 0; i < t; i++) {
            System.out.println(list.get(i).get(0) + " " + list.get(i).get(1));
        }
    }

    static List<Integer> isPalindrome(String s) {
        return recursion(s, 0, s.length() - 1);
    }

    static List<Integer> recursion(String s, int l, int r) {

        List<Integer> ss = s.chars().boxed().collect(Collectors.toList());

        if (l >= r) return List.of(1, l + 1);
        else if (ss.get(l) != ss.get(r)) return List.of(0, l + 1);
        else return recursion(s, l + 1, r - 1);
    }
}
package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Prob11478_3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String n = br.readLine();
        String[] arr = n.split("");
        int l = n.length();

        Set<String> set = new HashSet<>();

        for (int i = 0; i < l; i++) {

            StringBuilder result = new StringBuilder();

            for (int j = i; j < l; j++) {

                result.append(arr[j]);

                set.add(result.toString());
            }
        }

        System.out.println(set.size());
    }
}